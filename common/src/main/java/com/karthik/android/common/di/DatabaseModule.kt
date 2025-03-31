package com.karthik.poc.ebook.di

import android.content.Context
import androidx.room.Room
import com.karthik.android.common.data.cache.BookDatabase
import com.karthik.android.common.data.cache.dao.BookDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.jvm.java

/**
 * KMM POC
 *
 * Database Hilt Module class which will enable
 * dependency injection which can be injected relevant
 * scope [DatabaseModule]
 *
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    /**
     *Provides database initialization
     *can be injected for database instance wherever required
     */
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): BookDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            BookDatabase::class.java,
            "book_database.db"
        ).build()
    }

    /**
     *Provides dao instance
     *can be injected wherever required
     */
    @Singleton
    @Provides
    fun provideBookDao(database: BookDatabase): BookDao {
        return database.bookDao()
    }
}