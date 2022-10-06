package uz.gita.bookappcompose.navigator

import cafe.adriel.voyager.androidx.AndroidScreen

typealias AppScreen = AndroidScreen

interface AppNavigator {
    suspend fun back()
    suspend fun backAll()
    suspend fun backToRoot()
    suspend fun navigateTo(screen: AppScreen)
}