package uz.gita.bookappcompose.ui.splash

interface SplashScreenDirection {

    suspend fun navigateToIntroScreen()

    suspend fun navigateToMainScreen()
}