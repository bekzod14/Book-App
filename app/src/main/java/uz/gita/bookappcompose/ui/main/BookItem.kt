package uz.gita.bookappcompose.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.gita.bookappcompose.R
import uz.gita.bookappcompose.data.models.BookData
import uz.gita.bookappcompose.ui.theme.BookAppTheme

@Preview
@Composable
fun MockView() {
    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            item {
                BookItem(
                    BookData(
                        1,
                        "Halqa",
                        "Ajoyib",
                        "",
                        "",
                        "Akrom Malik",
                        1,
                        "",
                        1,
                        1,
                        1
                    )
                )
            }
        }
    }
}

@Composable
fun BookItem(
    bookData: BookData
) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .size(200.dp, 310.dp)
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .weight(6f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.book1),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

        }

        Text(
            modifier = Modifier
                .weight(1f)
                .padding(top = 10.dp),
            text = bookData.author,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            color = Color.Gray
        )

        Text(
            modifier = Modifier
                .weight(1f)
                .padding(top = 10.dp),
            text = bookData.name,
            fontSize = 24.sp,
            color = Color.Black
        )

    }

}

@Preview
@Composable
fun BookItemPreview() {
    BookAppTheme {
        BookItem(
            BookData(
                1,
                "Halqa",
                "Ajoyib",
                "",
                "",
                "Akrom Malik",
                1,
                "",
                1,
                1,
                1
            )
        )
    }
}
