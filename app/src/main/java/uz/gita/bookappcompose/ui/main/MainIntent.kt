package uz.gita.bookappcompose.ui.main

// Created by Jamshid Isoqov an 10/6/2022
sealed interface MainIntent {
    object BooksClicked : MainIntent
    object SavedBooksClicked : MainIntent
}