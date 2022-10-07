package uz.gita.bookappcompose.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.bookappcompose.data.models.BookData
import uz.gita.bookappcompose.domain.repository.impl.DownloadResult

interface InfoUseCase {
    fun downloadBook(bookData: BookData): Flow<DownloadResult>
    suspend fun cancelDownload(bookData: BookData)
    suspend fun readBook(bookData: BookData)
}