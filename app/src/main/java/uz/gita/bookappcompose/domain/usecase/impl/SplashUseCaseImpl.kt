package uz.gita.bookappcompose.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.bookappcompose.domain.repository.BookRepository
import uz.gita.bookappcompose.domain.usecase.SplashUseCase
import javax.inject.Inject

class SplashUseCaseImpl @Inject constructor(
    private val repository: BookRepository
) : SplashUseCase {
    override suspend fun isFirstEnter(): Flow<Boolean> = repository.isFirstEnter()
}