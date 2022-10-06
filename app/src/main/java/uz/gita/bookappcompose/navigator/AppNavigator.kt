package uz.gita.composeexample2.navigator

import cafe.adriel.voyager.androidx.AndroidScreen

typealias AppScreen = AndroidScreen

interface AppNavigator {
    suspend fun back()
    suspend fun backAll()
    suspend fun backToRoot()
    suspend fun navigateTo(screen: AppScreen)
}