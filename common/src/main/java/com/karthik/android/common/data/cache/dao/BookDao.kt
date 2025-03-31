package com.karthik.android.common.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.karthik.android.common.data.cache.entity.BookEntity

/**
 * KMM POC
 *
 * ArticleEntity data class which will hold
 * all the info about a ArticleEntity table [BookDao]
 *
 */
@Dao
interface BookDao {
    /**
     * Handles book insertion
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook( book: BookEntity)

    /**
     * Handles fetch books from the table
     */
    @Query("SELECT * FROM books")
    suspend fun getAllBooks(): List<BookEntity>
}
