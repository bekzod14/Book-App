package uz.gita.bookappcompose.data.source.local.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import uz.gita.bookappcompose.data.models.BookData

@Dao
interface BookDao {

    @Insert
    fun insert(bookData: BookData)

    @Update
    fun update(bookData: BookData)

    @Delete
    fun delete(bookData: BookData)

    @Query("SELECT * FROM BookData WHERE id=:id LIMIT 1")
    fun getBook(id: Long): BookData?

    @Query("SELECT * FROM BookData")
    fun getSavedBooks(): Flow<List<BookData>>



}