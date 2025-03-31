package com.karthik.android.common.data.network

import com.karthik.android.common.data.model.BookList
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * KMM POC
 *
 * ApiService interface which will hold
 * network call methods [ApiService]
 *
 */
interface ApiService {
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json")
    @GET("/api/recent")
    suspend fun getBooks(): BookList
}