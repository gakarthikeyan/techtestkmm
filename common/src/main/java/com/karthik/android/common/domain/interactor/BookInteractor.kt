package com.karthik.android.common.domain.interactor


import com.karthik.android.common.data.cache.entity.BookEntity
import com.karthik.android.common.data.model.BookList
import com.karthik.android.common.domain.usecase.BookUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BookInteractor @Inject constructor(private val bookUseCase: BookUseCase):
    BaseInteractor<Any, Any> {
    override suspend fun execute(): List<BookEntity> {
        return bookUseCase.execute()
    }

    override suspend fun executeRemote(): BookList {
        return bookUseCase.executeRemote()
    }

    override suspend fun execute(params: Any) {
        bookUseCase.execute(params as BookEntity)
    }
}