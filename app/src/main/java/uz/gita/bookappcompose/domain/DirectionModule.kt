package uz.gita.bookappcompose.domain

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.bookappcompose.ui.splash.SplashScreenDirection
import uz.gita.bookappcompose.ui.splash.SplashScreenDirectionImpl


@Module
@InstallIn(ViewModelComponent::class)
interface DirectionModule {

    @Binds
    fun bindSplashScreenDirection(impl: SplashScreenDirectionImpl): SplashScreenDirection
}