package uz.gita.bookappcompose.ui.books

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import uz.gita.bookappcompose.presenter.MainViewModelImpl
import uz.gita.bookappcompose.ui.main.*
import uz.gita.bookappcompose.ui.theme.BookAppTheme
import uz.gita.bookappcompose.ui.theme.SELECTED_ICON_COLOR

class BooksScreen : AndroidScreen() {
    @Composable
    override fun Content() {

        val viewModel: MainViewModel = getViewModel<MainViewModelImpl>()
        val uiState = viewModel.collectAsState().value

        BookAppTheme {
            BooksScreenContent(uiState, viewModel::onEventDispatcher)
        }
    }

    @SuppressLint("NotConstructor")
    @Composable
    fun BooksScreenContent(uiState: MainUiState, eventDispatcher: (MainIntent) -> Unit) {

        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(SELECTED_ICON_COLOR)
            ) {

                when (uiState) {

                    is MainUiState.Books -> {
                        if (uiState.books.isEmpty()) {

                            Text(text = "Saved", modifier = Modifier.align(Alignment.Center))
                        } else {
                            LazyColumn {
                                items(uiState.books) {
                                    BookItem(it, eventDispatcher)
                                }
                            }
                        }
                    }
                    else -> {}
                }

            }
        }
    }
}

