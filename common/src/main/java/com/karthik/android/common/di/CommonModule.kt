package com.karthik.android.common.di

import com.karthik.android.common.data.cache.dao.BookDao
import com.karthik.android.common.data.network.ApiService
import com.karthik.android.common.data.repository.BookRepositoryImpl
import com.karthik.android.common.domain.repository.BookRepository
import com.karthik.android.common.domain.usecase.BookUseCase
import com.karthik.android.common.domain.interactor.BookInteractor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CommonModule {

    @Provides
    @Singleton
    fun provideBookRepository(bookDao: BookDao, apiService: ApiService): BookRepository {
        return BookRepositoryImpl(bookDao, apiService)

    }

    @Provides
    @Singleton
    fun provideBookUseCase(bookRepository: BookRepository): BookUseCase{
        return BookUseCase(bookRepository)
    }

    @Provides
    @Singleton
    fun provideBookInteractor(bookUseCase: BookUseCase): BookInteractor{
        return BookInteractor(bookUseCase)
    }
}