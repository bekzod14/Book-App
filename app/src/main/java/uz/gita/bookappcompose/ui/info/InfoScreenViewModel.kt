package uz.gita.bookappcompose.ui.info

import com.downloader.Progress
import uz.gita.bookappcompose.data.models.BookData
import uz.gita.bookappcompose.utils.AppViewModel

interface InfoScreenViewModel : AppViewModel<Intent, UIState, Nothing> {

    fun setBookData(bookData: BookData)
}


sealed interface Intent {
    object Back : Intent
    data class DownloadBook(val data: BookData) : Intent
    data class ReadBook(val data: BookData) : Intent
    data class CancelDownload(val data: BookData) : Intent
}

sealed interface UIState {
    data class Error(val message: String) : UIState
    object Loading : UIState
    data class Success(
        val bookData: BookData,
        val progress: Progress? = null,
        var start: Boolean = true,
        val end: Boolean = false
    ) : UIState

}


