package uz.gita.bookappcompose.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.bookappcompose.navigator.AppNavigator
import uz.gita.bookappcompose.navigator.NavigationHandler
import uz.gita.bookappcompose.navigator.NavigatorDispatcher

@Module
@InstallIn(SingletonComponent::class)
interface NavigatorModule {

    @Binds
    fun appNavigator(dispatcher: NavigatorDispatcher): AppNavigator

    @Binds
    fun navigationHandler(dispatcher: NavigatorDispatcher): NavigationHandler
}