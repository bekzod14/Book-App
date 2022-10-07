package uz.gita.bookappcompose.ui.intro

import uz.gita.bookappcompose.navigator.AppNavigator
import uz.gita.bookappcompose.ui.main.MainScreen
import javax.inject.Inject

class IntroScreenDirectionImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : IntroScreenDirection {
    override suspend fun navigateToMainScreen() {
        appNavigator.navigateForSplash(MainScreen())
    }
}