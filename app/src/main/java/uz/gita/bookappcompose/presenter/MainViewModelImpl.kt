package uz.gita.bookappcompose.presenter

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.bookappcompose.ui.main.MainIntent
import uz.gita.bookappcompose.ui.main.MainUiState
import uz.gita.bookappcompose.ui.main.MainViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject constructor() : MainViewModel, ViewModel() {

    override val container: Container<MainUiState, Nothing> = container(MainUiState.Books)

    override fun onEventDispatcher(intent: MainIntent) = intent {
        when (intent) {

            MainIntent.BooksClicked -> {
                reduce {
                    MainUiState.Books
                }
            }
            MainIntent.SavedBooksClicked -> {
                reduce {
                    MainUiState.SavedBooks
                }
            }
        }
    }
}