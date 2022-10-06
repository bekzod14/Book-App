package uz.gita.bookappcompose.ui.intro

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.bookappcompose.utils.AppViewModel
import javax.inject.Inject

interface IntroScreenViewModel : AppViewModel<Intent, Unit, Nothing>

sealed interface Intent {

    object OpenMain : Intent
}
