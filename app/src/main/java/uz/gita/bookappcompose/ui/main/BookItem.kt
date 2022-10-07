package uz.gita.bookappcompose.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.gita.bookappcompose.R
import uz.gita.bookappcompose.ui.theme.BookAppTheme


@Composable
fun BookItem(
    image: Int,
    author: String,
    bookName: String,
) {
    Card {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

    }
}

@Preview
@Composable
fun BookItemPreview() {
    BookAppTheme {
        BookItem(R.drawable.book1, "Akrom Malik", "Halqa")
    }
}
