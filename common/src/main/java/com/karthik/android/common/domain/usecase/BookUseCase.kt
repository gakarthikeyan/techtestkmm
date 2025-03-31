package com.karthik.android.common.domain.usecase


import com.karthik.android.common.data.cache.entity.BookEntity
import com.karthik.android.common.data.model.BookList
import com.karthik.android.common.domain.repository.BookRepository
import com.karthik.poc.ebook.domain.usecase.base.BaseUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BookUseCase @Inject constructor(
    private val bookRepository: BookRepository
): BaseUseCase<Any, Any>
{
    override suspend fun execute(): List<BookEntity> {
        return bookRepository.getCachedBooks()
    }

    override suspend fun executeRemote(): BookList {
        return bookRepository.getBooks()
    }

    override suspend fun execute(params: Any) {
        bookRepository.insertBook(params as BookEntity)
    }
}