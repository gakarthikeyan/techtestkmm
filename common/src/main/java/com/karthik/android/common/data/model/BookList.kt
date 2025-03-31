package com.karthik.android.common.data.model


import com.google.gson.annotations.SerializedName
/**
 * KMM POC
 *
 * Book data class which will hold
 * all the info about a book request [BookList]
 *
 */
data class BookList(
    @SerializedName("books")
    val books: List<Book>,
    @SerializedName("status")
    val status: String,
    @SerializedName("total")
    val total: Int
)