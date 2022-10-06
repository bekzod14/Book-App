package uz.gita.bookappcompose.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.gita.bookappcompose.data.source.local.room.AppDatabase
import uz.gita.bookappcompose.data.source.local.room.BookDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @[Provides Singleton]
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "book_db").build()

    @[Provides Singleton]
    fun provideBookDao(appDatabase: AppDatabase): BookDao = appDatabase.bookDao()

}