package uz.gita.bookappcompose.ui.main

import uz.gita.bookappcompose.data.models.BookData
import uz.gita.bookappcompose.utils.AppViewModel

// Created by Jamshid Isoqov an 10/6/2022
interface MainViewModel : AppViewModel<MainIntent, MainUiState, Nothing>

sealed interface MainIntent {

    class BooksClicked(val bookData: BookData) : MainIntent
    class SavedBooksClicked(val bookData: BookData) : MainIntent

}

sealed interface MainUiState {

    object Loading : MainIntent, MainUiState
    object Empty : MainIntent

    data class Books(
        val books: List<BookData>,
        val bookData: BookData? = null
    ) : MainUiState

    data class SavedBooks(
        val savedBooks: List<BookData>,
        val bookData: BookData? = null
    ) : MainUiState
}