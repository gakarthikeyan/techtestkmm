package com.karthik.android.common.data.model

/**
 * KMM POC
 *
 * BookX data class which will hold
 * all the info about a book [BookX]
 *
 */
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class Book(
    @SerializedName("authors")
    val authors: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
)