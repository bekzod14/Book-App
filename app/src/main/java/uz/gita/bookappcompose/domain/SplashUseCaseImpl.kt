package uz.gita.bookappcompose.domain

import kotlinx.coroutines.flow.Flow
import uz.gita.bookappcompose.data.repository.BookRepository
import javax.inject.Inject

class SplashUseCaseImpl @Inject constructor(
    private val repository: BookRepository
) : SplashUseCase {
    override suspend fun isFirstEnter(): Flow<Boolean> = repository.isFirstEnter()
}