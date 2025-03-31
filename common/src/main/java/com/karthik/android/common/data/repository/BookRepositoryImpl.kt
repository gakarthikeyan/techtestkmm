package com.karthik.android.common.data.repository

import com.karthik.android.common.data.cache.dao.BookDao
import com.karthik.android.common.data.cache.entity.BookEntity
import com.karthik.android.common.data.model.BookList
import com.karthik.android.common.data.network.ApiService
import com.karthik.android.common.domain.repository.BookRepository

class BookRepositoryImpl(private val bookDao: BookDao,
                         private val apiService: ApiService): BookRepository {

    override suspend fun insertBook(bookEntity: BookEntity) {
        bookDao.insertBook(bookEntity)
    }

    override suspend fun getCachedBooks(): List<BookEntity> {
        return bookDao.getAllBooks()
    }

    override suspend fun getBooks(): BookList {
        return apiService.getBooks()
    }
}