package uz.gita.bookappcompose.domain

import kotlinx.coroutines.flow.Flow

interface SplashUseCase {

    suspend fun isFirstEnter(): Flow<Boolean>
}