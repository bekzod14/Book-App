package uz.gita.bookappcompose.ui.saved

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
import uz.gita.bookappcompose.ui.main.BookItem
import uz.gita.bookappcompose.ui.main.MainIntent
import uz.gita.bookappcompose.ui.main.MainUiState
import uz.gita.bookappcompose.ui.main.MainViewModel
import uz.gita.bookappcompose.ui.theme.BookAppTheme
import uz.gita.bookappcompose.ui.theme.SELECTED_ICON_COLOR

// Created by Jamshid Isoqov an 10/6/2022
class SavedBooksScreen : AndroidScreen() {
    @Composable
    override fun Content() {

        val viewModel: MainViewModel = getViewModel<MainViewModelImpl>()
        val uiState = viewModel.collectAsState().value

        BookAppTheme {
            SavedScreenContent(uiState, viewModel::onEventDispatcher)
        }
    }

    @SuppressLint("NotConstructor")
    @Composable
    fun SavedScreenContent(uiState: MainUiState, eventDispatcher: (MainIntent) -> Unit) {

        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(SELECTED_ICON_COLOR)
            ) {

                when (uiState) {

                    is MainUiState.SavedBooks -> {
                        if (uiState.savedBooks.isEmpty()) {

                            Text(text = "Saved", modifier = Modifier.align(Alignment.Center))
                        } else {
                            LazyColumn {
                                items(uiState.savedBooks) {
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
