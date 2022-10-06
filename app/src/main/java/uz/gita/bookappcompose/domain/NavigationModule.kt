package uz.gita.bookappcompose.domain

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.composeexample2.navigator.AppNavigator
import uz.gita.composeexample2.navigator.NavigationHandler
import uz.gita.composeexample2.navigator.NavigatorDispatcher


@Module
@InstallIn(SingletonComponent::class)
interface NavigatorModule {

    @Binds
    fun appNavigator(dispatcher: NavigatorDispatcher): AppNavigator

    @Binds
    fun navigationHandler(dispatcher: NavigatorDispatcher): NavigationHandler
}