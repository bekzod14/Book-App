package uz.gita.bookappcompose.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.bookappcompose.data.repository.BookRepository
import uz.gita.bookappcompose.data.repository.impl.BookRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun bindBookRepository(impl: BookRepositoryImpl): BookRepository

}