package uz.gita.bookappcompose.ui.main

import uz.gita.bookappcompose.utils.AppViewModel

// Created by Jamshid Isoqov an 10/6/2022
interface MainViewModel : AppViewModel<MainIntent, MainUiState, Nothing>

sealed interface Intent {


}

sealed interface MainIntent {

    object BooksClicked : MainIntent
    object SavedBooksClicked : MainIntent

}

sealed interface MainUiState {

    object Books : MainUiState
    object SavedBooks : MainUiState

}