package com.karthik.poc.ebook.domain.usecase.base

interface BaseUseCase<out T, in Params> {
    suspend fun execute(params: Params){}
    suspend fun execute(): T
    suspend fun executeRemote(): T
}