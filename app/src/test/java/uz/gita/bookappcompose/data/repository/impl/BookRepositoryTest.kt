package uz.gita.bookappcompose.data.repository.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.junit.Before
import uz.gita.bookappcompose.data.models.BookData
import uz.gita.bookappcompose.data.source.local.room.BookDao

// Created by Jamshid Isoqov an 10/7/2022
internal class BookRepositoryTest {

    private lateinit var bookDao: BookDao

    @Before
    fun setup() {

    }

}

class FakeBookDao() : BookDao {

    private val notes = mutableMapOf<Long, BookData>()


    override fun insert(bookData: BookData) {
        notes[bookData.id] = bookData
    }

    override fun update(bookData: BookData) {
        notes[bookData.id] = bookData
    }

    override fun delete(bookData: BookData) {
        notes.remove(bookData.id)
    }

    override fun getBook(id: Long): BookData? {
        return notes[id]
    }

    override fun getSavedBooks(): Flow<List<BookData>> = flow {

    }


}