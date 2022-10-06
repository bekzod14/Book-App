package uz.gita.bookappcompose.ui.splash

import uz.gita.bookappcompose.utils.AppViewModel


interface SplashViewModel : AppViewModel<IntentSplash, Unit, Nothing>

sealed interface IntentSplash {

    object OpenNext : IntentSplash

}