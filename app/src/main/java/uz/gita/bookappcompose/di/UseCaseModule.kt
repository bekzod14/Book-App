package uz.gita.bookappcompose.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.bookappcompose.domain.SplashUseCase
import uz.gita.bookappcompose.domain.SplashUseCaseImpl


@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bind(splashUseCase: SplashUseCaseImpl): SplashUseCase
}