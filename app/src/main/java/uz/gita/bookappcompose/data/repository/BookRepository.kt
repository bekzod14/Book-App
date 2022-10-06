package uz.gita.bookappcompose.data.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.bookappcompose.data.models.BookData
import uz.gita.bookappcompose.data.repository.impl.DownloadResult

interface BookRepository {

    fun getBooks(): Flow<List<BookData>>

    fun getSavedBooks(): Flow<List<BookData>>

    suspend fun updateBookData(bookData: BookData)

    fun downloadBook(bookData: BookData): Flow<DownloadResult>

    suspend fun cancelDownload(bookData: BookData)

}