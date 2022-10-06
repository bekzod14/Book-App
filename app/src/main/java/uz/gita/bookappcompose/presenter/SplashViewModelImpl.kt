package uz.gita.bookappcompose.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.bookappcompose.data.MySharedPreference
import uz.gita.bookappcompose.domain.SplashUseCase
import uz.gita.bookappcompose.ui.splash.SplashScreenDirection
import uz.gita.bookappcompose.ui.splash.SplashViewModel
import javax.inject.Inject


@HiltViewModel
class SplashViewModelImpl @Inject constructor(
    private val useCase: SplashUseCase,
    private val direction: SplashScreenDirection

) : SplashViewModel, ViewModel() {

    override fun onEventDispatcher(intent: Nothing) {}

    override val container: Container<Unit, Nothing> = container(Unit)

    init {
        viewModelScope.launch {
            delay(2000)
            useCase.isFirstEnter().collect() {
                if (it) {
                    direction.navigateToIntroScreen()
                } else {
                    direction.navigateToMainScreen()
                }
            }
        }
    }
}
