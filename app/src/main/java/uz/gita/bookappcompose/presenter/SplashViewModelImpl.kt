package uz.gita.bookappcompose.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.bookappcompose.data.MySharedPreference
import uz.gita.bookappcompose.ui.splash.IntentSplash
import uz.gita.bookappcompose.ui.splash.SplashScreenDirection
import uz.gita.bookappcompose.ui.splash.SplashViewModel
import javax.inject.Inject


@HiltViewModel
class SplashViewModelImpl @Inject constructor(
    private val direction: SplashScreenDirection
) : SplashViewModel, ViewModel() {

    private val sharedPreference = MySharedPreference.getInstance()

    override val container: Container<Unit, Nothing> = container(Unit)

    override fun onEventDispatcher(intent: IntentSplash) = intent {


        when (intent) {
            is IntentSplash.OpenNext -> {
                viewModelScope.launch {
                    delay(2000)
                    when (sharedPreference.getOpenScreen()) {
                        "Intro Screen" -> {
                            direction.navigateToIntroScreen()
                        }
                        "Main Screen" -> {
                            direction.navigateToMainScreen()
                        }
                    }
                }
            }
        }
    }
}