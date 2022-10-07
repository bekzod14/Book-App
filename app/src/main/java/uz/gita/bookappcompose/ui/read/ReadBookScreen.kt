package uz.gita.bookappcompose.ui.read

import android.net.Uri
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import cafe.adriel.voyager.androidx.AndroidScreen
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import uz.gita.bookappcompose.data.models.BookData
import uz.gita.bookappcompose.ui.theme.BookAppTheme

// Created by Jamshid Isoqov an 10/6/2022
class ReadBookScreen(
    private val bookData: BookData
) : AndroidScreen() {
    @Composable
    override fun Content() {
        BookAppTheme {
            ReadBookScreenContent(bookData)
        }
    }
}

@Composable
fun ReadBookScreenContent(book: BookData) {
    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(factory = {
            PDFView(it, null)
        }, modifier = Modifier.fillMaxSize()) {
            it.fromUri(Uri.parse(book.file))
                .defaultPage(0)
                .enableAnnotationRendering(true)
                .scrollHandle(DefaultScrollHandle(it.context))
                .spacing(10)
                .load()
        }

    }
}

@Composable
@Preview(showSystemUi = true)
fun ReadBookScreenPreview() {

}

