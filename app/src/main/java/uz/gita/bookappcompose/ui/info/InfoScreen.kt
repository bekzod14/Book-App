package uz.gita.bookappcompose.ui.info

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.downloader.Progress
import org.orbitmvi.orbit.compose.collectAsState
import uz.gita.bookappcompose.R
import uz.gita.bookappcompose.data.models.BookData
import uz.gita.bookappcompose.presenter.InfoScreenViewModelImpl


class InfoScreen(val bookData: BookData) : AndroidScreen() {

    @Composable
    override fun Content() {
        val viewModel: InfoScreenViewModel = getViewModel<InfoScreenViewModelImpl>()
        viewModel.setBookData(bookData)
        val uiState = viewModel.collectAsState().value
        InfoScreenContent(
            uiState = uiState,
            eventDispatcher = viewModel::onEventDispatcher,
            bookData
        )
    }

}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun InfoScreenContent(
    uiState: UIState,
    eventDispatcher: (Intent) -> Unit,
    bookData: BookData
) {
    val readOrDownloadText by remember {
        mutableStateOf("yuklash")
    }

    when (uiState) {

        UIState.Loading -> {
            CircularProgressIndicator(modifier = Modifier)
        }

        is UIState.Success -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(onClick = {
                    eventDispatcher(Intent.Back)
                }, modifier = Modifier.align(Alignment.Start)) {


                }
                BookImage(imagePath = uiState.bookData.img)
                BookName(bookName = uiState.bookData.name, authName = uiState.bookData.author)
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Rating(rating = uiState.bookData.rating)
                    Student(uquvchi = uiState.bookData.seen)
                }

                if (bookData.saved) {
                    Button(
                        onClick = {
                            eventDispatcher(Intent.ReadBook(bookData))
                        },
                        Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Text(text = if (uiState.bookData.saved) "o'qish" else " yuklash")

                        Toast.makeText(
                            LocalContext.current.applicationContext,
                            "o'qish",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                } else {

                    Button(
                        onClick = {
                            eventDispatcher(Intent.DownloadBook(bookData))
                        },
                        Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Text(text = "Yuklash")
                    }
                    if (uiState.progress != null) {
                        LinearProgressIndicator(progress = (uiState.progress.currentBytes / uiState.progress.totalBytes).toFloat())
                        if (uiState.progress.totalBytes == uiState.progress.currentBytes) {
                            uiState.bookData.saved = true
                        }
                    }
                }




                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "kitob haqida",
                        fontWeight = FontWeight.Normal,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                    Text(
                        text = uiState.bookData.description,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        color = Color.Black
                    )


                }


            }
        }
        is UIState.Error -> {


        }

    }
}


@Composable
@Preview
private fun InfoScreenPreview() {

}


@Composable
private fun BookName(
    bookName: String,
    authName: String
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = bookName,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,

            )
        Text(
            text = authName,
            fontSize = 16.sp,
            fontWeight = FontWeight.Light
        )

    }

}


@Composable
@Preview
fun BookNamePreview() {
    BookName(bookName = "Jangari", authName = "Alisher")
}

@ExperimentalCoilApi
@Composable
fun BookImage(imagePath: String) {
    val painter = rememberImagePainter(
        data = imagePath,
        builder = {
            placeholder(R.drawable.book1)
            crossfade(1000)
            error(R.drawable.ic_baseline_error_24)
        }
    )
    val painterState = painter.state
    if (painterState is ImagePainter.State.Loading) {
        CircularProgressIndicator()
    }
    Image(painter = painter, contentDescription = "book image", modifier = Modifier.fillMaxWidth())
}

@OptIn(ExperimentalCoilApi::class)
@Composable
@Preview
private fun PreviewBookImage() {
    BookImage(
        imagePath = "data:image/jpeg;base64,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"
    )
    Buttons()
}

@Composable
fun Buttons() {
    Box(modifier = Modifier.fillMaxWidth(), Alignment.Center) {
        Column() {


            Button(
                onClick = { /*TODO*/ },
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(text = "Fragment O'qish")
            }
        }


    }

}


@Composable
fun Student(
    uquvchi: Long
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painterResource(id = R.drawable.ic_person),
                contentDescription = "image",
                modifier = Modifier.size(28.dp)
            )
            Text(text = "O'quvchilar", fontSize = 15.sp)


        }
        Text(text = "$uquvchi", fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }


}

@Composable
fun Rating(
    rating: Long
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painterResource(
                    id = R.drawable.ic_barchart
                ), contentDescription = "image", modifier = Modifier.size(28.dp)
            )
            Text(text = "Reyting", fontSize = 15.sp)


        }
        Text(text = "$rating", fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }


}

@Composable
@Preview
fun ScreenPreView() {
    InfoScreenContent(
        UIState.Success(
            BookData(
                1,
                "Jangari",
                "vala vala",
                "https://yt3.ggpht.com/ytc/AMLnZu_GE-UWpU0n0G50pDKouVN9hBDEk0ZhdV2kFq6V4Q=s88-c-k-c0x00ffffff-no-rj",
                "https://yt3.ggpht.com/ytc/AMLnZu_GE-UWpU0n0G50pDKouVN9hBDEk0ZhdV2kFq6V4Q=s88-c-k-c0x00ffffff-no-rj",
                "Shoxrux",
                1222,
                "122",
                44,
                3333,
                32,
                false,
                23
            ),
            Progress(12, 111),
        ),
        {},
        BookData(
            1,
            "Jangari",
            "vala vala",
            "https://yt3.ggpht.com/ytc/AMLnZu_GE-UWpU0n0G50pDKouVN9hBDEk0ZhdV2kFq6V4Q=s88-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/ytc/AMLnZu_GE-UWpU0n0G50pDKouVN9hBDEk0ZhdV2kFq6V4Q=s88-c-k-c0x00ffffff-no-rj",
            "Shoxrux",
            1222,
            "122",
            44,
            3333,
            32,
            false,
            23
        )

    )
}