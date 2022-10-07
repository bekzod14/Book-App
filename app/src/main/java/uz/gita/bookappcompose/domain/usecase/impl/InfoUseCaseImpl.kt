package uz.gita.bookappcompose.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.bookappcompose.data.models.BookData
import uz.gita.bookappcompose.domain.repository.BookRepository
import uz.gita.bookappcompose.domain.repository.impl.DownloadResult
import uz.gita.bookappcompose.domain.usecase.InfoUseCase
import javax.inject.Inject

class InfoUseCaseImpl @Inject constructor(private val repository: BookRepository) :
    InfoUseCase {
    override fun downloadBook(bookData: BookData): Flow<DownloadResult> =
        repository.downloadBook(bookData)

    override suspend fun cancelDownload(bookData: BookData) {
        repository.cancelDownload(bookData)
    }

    override suspend fun readBook(bookData: BookData) {
        repository
    }
}