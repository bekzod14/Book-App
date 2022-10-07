package uz.gita.bookappcompose.domain.usecase

import kotlinx.coroutines.flow.Flow

interface SplashUseCase {

    suspend fun isFirstEnter(): Flow<Boolean>
}