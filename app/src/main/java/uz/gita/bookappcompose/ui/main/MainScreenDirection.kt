package uz.gita.bookappcompose.ui.main

import uz.gita.bookappcompose.data.models.BookData

interface MainScreenDirection {

    suspend fun navigateToInfoScreen(bookData: BookData)

    suspend fun navigateToReadScreen(bookData: BookData)
}