package uz.gita.bookappcompose.ui.main

import uz.gita.bookappcompose.data.models.BookData
import uz.gita.bookappcompose.navigator.AppNavigator
import uz.gita.bookappcompose.ui.info.InfoScreen
import uz.gita.bookappcompose.ui.read.ReadBookScreen
import javax.inject.Inject

class MainScreenDirectionImpl @Inject constructor(private val appNavigator: AppNavigator) :
    MainScreenDirection {
    override suspend fun navigateToInfoScreen(bookData: BookData) =
        appNavigator.navigateTo(InfoScreen(bookData))

    override suspend fun navigateToReadScreen(bookData: BookData) =
        appNavigator.navigateTo(ReadBookScreen(bookData))
}