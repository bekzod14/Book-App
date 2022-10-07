package uz.gita.bookappcompose.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.bookappcompose.domain.usecase.InfoUseCase
import uz.gita.bookappcompose.domain.usecase.MainUseCase
import uz.gita.bookappcompose.domain.usecase.SplashUseCase
import uz.gita.bookappcompose.domain.usecase.impl.InfoUseCaseImpl
import uz.gita.bookappcompose.domain.usecase.impl.MainUseCaseImpl
import uz.gita.bookappcompose.domain.usecase.impl.SplashUseCaseImpl


@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindSlash(splashUseCase: SplashUseCaseImpl): SplashUseCase

    @Binds
    fun bindMain(mainUseCase: MainUseCaseImpl): MainUseCase

    @Binds
    fun provideInfoScreenUseCase(infoScreenUseCaseImpl: InfoUseCaseImpl): InfoUseCase
}