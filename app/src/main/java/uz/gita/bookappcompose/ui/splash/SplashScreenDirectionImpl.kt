package uz.gita.bookappcompose.ui.splash

import uz.gita.bookappcompose.ui.intro.IntroScreen
import uz.gita.bookappcompose.ui.main.MainScreen
import uz.gita.composeexample2.navigator.AppNavigator
import javax.inject.Inject

class SplashScreenDirectionImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : SplashScreenDirection {

    override suspend fun navigateToIntroScreen() {
        appNavigator.navigateTo(IntroScreen())
    }

    override suspend fun navigateToMainScreen() {
        appNavigator.navigateTo(MainScreen())
    }
}