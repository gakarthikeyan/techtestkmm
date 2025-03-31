package com.karthik.android.common.domain.repository

import com.karthik.android.common.data.cache.entity.BookEntity
import com.karthik.android.common.data.model.BookList
import kotlinx.coroutines.flow.Flow

interface BookRepository: BaseRepository {
    suspend fun insertBook(bookEntity: BookEntity)
    suspend fun getCachedBooks(): List<BookEntity>
    suspend fun getBooks(): BookList
}