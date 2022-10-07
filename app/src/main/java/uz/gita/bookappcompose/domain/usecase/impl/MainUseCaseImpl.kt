package uz.gita.bookappcompose.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.bookappcompose.data.models.BookData
import uz.gita.bookappcompose.domain.repository.BookRepository
import uz.gita.bookappcompose.domain.usecase.MainUseCase
import javax.inject.Inject

class MainUseCaseImpl @Inject constructor(private val repository: BookRepository) :
    MainUseCase {

    override fun getBooks(): Flow<List<BookData>> = repository.getBooks()

    override fun savedBooks(): Flow<List<BookData>> = repository.getSavedBooks()
}