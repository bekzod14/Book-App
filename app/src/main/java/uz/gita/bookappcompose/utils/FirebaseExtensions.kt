package uz.gita.bookappcompose.utils

import com.google.firebase.firestore.DocumentSnapshot
import uz.gita.bookappcompose.data.models.BookData


fun DocumentSnapshot.toBookData() = BookData(
    getLong("id")!!,
    getString("name")!!,
    getString("description")!!,
    getString("img")!!,
    getString("file")!!,
    getString("author")?:"1111",
    getLong("page")?:0,
    getString("lang")?:"",
    getLong("rating")?:0,
    getLong("seen")?:0,
    getLong("category")?:0,
)