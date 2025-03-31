package com.karthik.android.common.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.karthik.android.common.data.cache.dao.BookDao
import com.karthik.android.common.data.cache.entity.BookEntity

/**
 * KMM POC
 *
 * BookDatabase class which will hold
 * all the entity names and DAO info [BookDatabase]
 *
 */
@Database(entities = [BookEntity::class], version = 1, exportSchema = false)
abstract class BookDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
}