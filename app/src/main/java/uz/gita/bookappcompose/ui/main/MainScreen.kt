package uz.gita.bookappcompose.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import uz.gita.bookappcompose.R
import uz.gita.bookappcompose.presenter.MainViewModelImpl
import uz.gita.bookappcompose.ui.theme.BookAppTheme
import uz.gita.bookappcompose.ui.theme.SELECTED_ICON_COLOR

class MainScreen : AndroidScreen() {
    @Composable
    override fun Content() {

        val viewModel: MainViewModel = getViewModel<MainViewModelImpl>()
        //viewModel.onEventDispatcher(MainIntent.BooksClicked)
        val uiState = viewModel.collectAsState().value

        BookAppTheme {
            MainScreenContent(uiState, viewModel::onEventDispatcher)
        }
    }
}

@Composable
fun MainScreenContent(uiState: MainUiState, eventDispatcher: (MainIntent) -> Unit) {
    val isHome = when (uiState) {
        MainUiState.Books -> {
            true
        }
        MainUiState.SavedBooks -> {
            false
        }
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(SELECTED_ICON_COLOR)
        ) {

            if (isHome) {
                //Text(text = "Main", modifier = Modifier.align(Alignment.Center))
            } else {
                //Text(text = "Saved", modifier = Modifier.align(Alignment.Center))
            }

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
        ) {
            BottomNavItem(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                imageRes = R.drawable.ic_home,
                name = "Home",
                isSelected = isHome
            ) {
                eventDispatcher.invoke(MainIntent.BooksClicked)

            }



            BottomNavItem(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                imageRes = R.drawable.ic_bookmark,
                name = "Saved",
                isSelected = !isHome
            ) {
                eventDispatcher.invoke(MainIntent.SavedBooksClicked)
            }

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview() {
    BookAppTheme {
        MainScreenContent(MainUiState.Books) {

        }
    }
}


