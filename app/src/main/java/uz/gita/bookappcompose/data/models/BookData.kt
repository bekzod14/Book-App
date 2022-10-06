package uz.gita.bookappcompose.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BookData(
    @PrimaryKey
    val id: Long,
    val name: String,
    val description: String,
    val img: String,
    val file: String,
    val author: String,
    val page: Long,
    val lang: String,
    val rating: Long,
    val seen: Long,
    val category: Long,
    val saved: Boolean = false,
    var currentPage: Int = 0
)
