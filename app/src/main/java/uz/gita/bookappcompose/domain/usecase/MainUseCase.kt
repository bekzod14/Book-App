package uz.gita.bookappcompose.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.bookappcompose.data.models.BookData

interface MainUseCase {
    fun getBooks(): Flow<List<BookData>>
    fun savedBooks(): Flow<List<BookData>>

}