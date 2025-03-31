package com.karthik.poc.ebook.di


import com.karthik.android.common.data.network.ApiService
import com.karthik.android.common.data.utils.StringUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.jvm.java

/**
 * KMM POC
 *
 * Network Hilt Module class which will enable
 * dependency injection which can be injected relevant
 * scope [NetworkModule]
 *
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    /**
     *Provide OkHttpClient
     *can be injected wherever required
     */
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    /**
     *Provide Retrofit
     *can be injected wherever required
     */
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(StringUtils.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     *Provide ApiService
     *can be injected wherever required
     */
    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}