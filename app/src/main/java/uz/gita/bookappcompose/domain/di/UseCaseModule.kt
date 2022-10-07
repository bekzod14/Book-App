package uz.gita.bookappcompose.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.bookappcompose.domain.usecase.MainUseCase
import uz.gita.bookappcompose.domain.usecase.SplashUseCase
import uz.gita.bookappcompose.domain.usecase.impl.MainUseCaseImpl
import uz.gita.bookappcompose.domain.usecase.impl.SplashUseCaseImpl


@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bind(splashUseCase: SplashUseCaseImpl): SplashUseCase

    @Binds
    fun bind(mainUseCase: MainUseCaseImpl): MainUseCase
}