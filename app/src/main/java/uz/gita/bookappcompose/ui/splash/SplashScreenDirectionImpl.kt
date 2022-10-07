package uz.gita.bookappcompose.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.gita.bookappcompose.navigator.AppNavigator
import uz.gita.bookappcompose.ui.intro.IntroScreen
import uz.gita.bookappcompose.ui.main.MainScreen
import javax.inject.Inject

class SplashScreenDirectionImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : SplashScreenDirection, ViewModel() {

    init {
        viewModelScope.launch {

        }
    }

    override suspend fun navigateToIntroScreen() {
        appNavigator.navigateForSplash(IntroScreen())
    }

    override suspend fun navigateToMainScreen() {
        appNavigator.navigateForSplash(MainScreen())
    }
}