package uz.gita.bookappcompose.presenter

import androidx.lifecycle.ViewModel
import com.downloader.Progress
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.bookappcompose.data.models.BookData
import uz.gita.bookappcompose.domain.repository.impl.DownloadResult
import uz.gita.bookappcompose.domain.usecase.InfoUseCase
import uz.gita.bookappcompose.ui.info.InfoScreenViewModel
import uz.gita.bookappcompose.ui.info.Intent
import uz.gita.bookappcompose.ui.info.UIState
import javax.inject.Inject

class InfoScreenViewModelImpl @Inject constructor(private val infoScreenUseCase: InfoUseCase) :
    InfoScreenViewModel, ViewModel() {
    override val container: Container<UIState, Nothing> = container(
        UIState.Loading
    )

    override fun setBookData(bookData: BookData) {
        intent {
            reduce {
                UIState.Success(bookData)
            }
        }
    }

    override fun onEventDispatcher(intent: Intent) = intent {
        when (intent) {
            is Intent.DownloadBook -> {

                infoScreenUseCase.downloadBook(intent.data).collect { downloadResult ->

                    when (downloadResult) {
                        DownloadResult.Start -> {


                        }
                        DownloadResult.End -> {


                        }
                        is DownloadResult.Progress -> {
                            (state as UIState.Success).copy(
                                progress = Progress(
                                    downloadResult.current,
                                    downloadResult.total
                                )
                            )
                        }
                        is DownloadResult.Error -> {

                        }
                    }
                }
            }
            is Intent.CancelDownload -> {
                infoScreenUseCase.cancelDownload(intent.data)
            }
            is Intent.ReadBook -> {
                infoScreenUseCase.readBook(intent.data)
            }
            Intent.Back -> {

            }
        }

    }
}