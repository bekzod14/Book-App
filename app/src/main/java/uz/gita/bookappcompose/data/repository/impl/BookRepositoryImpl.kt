package uz.gita.bookappcompose.data.repository.impl

import android.os.Environment
import android.util.Log
import androidx.room.Dao
import com.downloader.Error
import com.downloader.OnDownloadListener
import com.downloader.PRDownloader
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import com.kiwimob.firestore.coroutines.snapshotAsFlow
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import uz.gita.bookappcompose.data.MySharedPreference
import uz.gita.bookappcompose.data.models.BookData
import uz.gita.bookappcompose.data.repository.BookRepository
import uz.gita.bookappcompose.data.source.local.room.BookDao
import uz.gita.bookappcompose.utils.toBookData
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val dao: BookDao,

    ) : BookRepository {
    private val dirPath = Environment.getExternalStorageDirectory().absolutePath
    private val preference = MySharedPreference.getInstance()
    private val firestore = FirebaseFirestore.getInstance()

    override fun getBooks(): Flow<List<BookData>> =
        firestore.collection("books").snapshotAsFlow().map { it.documents.map { it.toBookData() } }

    override fun getSavedBooks(): Flow<List<BookData>> = dao.getSavedBooks()

    override suspend fun updateBookData(bookData: BookData) = dao.update(bookData)

    override fun downloadBook(bookData: BookData): Flow<DownloadResult> = callbackFlow {
        PRDownloader.download(
            bookData.file,
            dirPath.plus("/${Environment.DIRECTORY_DOCUMENTS}"),
            bookData.name
        ).setTag(bookData.id)
            .build()
            .setOnStartOrResumeListener {
                trySend(DownloadResult.Start)
            }
            .setOnProgressListener {
                trySend(DownloadResult.Progress(it.currentBytes, it.totalBytes))
            }.start(object : OnDownloadListener {
                override fun onDownloadComplete() {
                    trySend(DownloadResult.End)
                }

                override fun onError(error: Error?) {
                    trySend(DownloadResult.Error(error.toString()))
                }
            })

        awaitClose {
            PRDownloader.cancel(bookData.id)
        }
    }

    override suspend fun cancelDownload(bookData: BookData) {
        PRDownloader.cancel(bookData.id)
    }

    override suspend fun isFirstEnter(): Flow<Boolean> = flow {
        emit(preference.getIsFirst())
    }
}


sealed interface DownloadResult {
    object Start : DownloadResult
    object End : DownloadResult
    class Progress(val current: Long, val total: Long) : DownloadResult
    class Error(val message: String) : DownloadResult
}