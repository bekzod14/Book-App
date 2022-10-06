package uz.gita.bookappcompose.utils

import com.google.firebase.firestore.DocumentSnapshot
import uz.gita.bookappcompose.data.models.BookData


fun DocumentSnapshot.toBookData() = BookData(
    getLong("id")!!,
    getString("name")!!,
    getString("description")!!,
    getString("img")!!,
    getString("file")!!,
    getString("author")!!,
    getLong("page")!!,
    getString("lang")!!,
    getLong("rating")!!,
    getLong("seen")!!,
    getLong("category")!!,
)