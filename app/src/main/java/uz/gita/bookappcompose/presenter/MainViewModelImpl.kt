package uz.gita.bookappcompose.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.bookappcompose.domain.usecase.MainUseCase
import uz.gita.bookappcompose.ui.intro.Intent
import uz.gita.bookappcompose.ui.main.MainIntent
import uz.gita.bookappcompose.ui.main.MainUiState
import uz.gita.bookappcompose.ui.main.MainViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl @Inject constructor(
    private val useCase: MainUseCase,

    ) : MainViewModel, ViewModel() {

    override val container: Container<MainUiState, Nothing> = container(MainUiState.Loading)

    init {
        useCase.getBooks().onEach {
            intent {
                reduce {
                    MainUiState.Books(it)
                }
            }
        }.launchIn(viewModelScope)

        useCase.savedBooks().onEach {
            intent {
                reduce { MainUiState.SavedBooks(it) }
            }
        }.launchIn(viewModelScope)
    }

    override fun onEventDispatcher(intent: MainIntent) = intent {
        when (intent) {
            is MainIntent.BooksClicked -> reduce {
                (container.stateFlow.value as MainUiState.Books).copy(bookData = intent.bookData)
            }
            is MainIntent.SavedBooksClicked -> reduce {
                (container.stateFlow.value as MainUiState.SavedBooks).copy(bookData = intent.bookData)
            }
            else -> {}
        }
    }
}
