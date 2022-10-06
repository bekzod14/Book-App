package uz.gita.bookappcompose.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.bookappcompose.ui.intro.Intent
import uz.gita.bookappcompose.ui.intro.IntroScreenDirection
import uz.gita.bookappcompose.ui.intro.IntroScreenViewModel
import javax.inject.Inject

@HiltViewModel
class IntroScreenViewModelImpl @Inject constructor(
    private val direction: IntroScreenDirection
) : IntroScreenViewModel, ViewModel() {
    override fun onEventDispatcher(intent: Intent) = intent {

        reduce {
            viewModelScope.launch {
                direction.navigateToMainScreen()
            }
        }
    }
    override val container: Container<Unit, Nothing> = container(Unit)
}