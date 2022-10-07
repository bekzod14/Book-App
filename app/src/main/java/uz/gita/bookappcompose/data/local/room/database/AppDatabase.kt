package uz.gita.bookappcompose.data.local.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.gita.bookappcompose.data.local.room.dao.BookDao
import uz.gita.bookappcompose.data.models.BookData

@Database(
    entities = [BookData::class], version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun bookDao(): BookDao

}