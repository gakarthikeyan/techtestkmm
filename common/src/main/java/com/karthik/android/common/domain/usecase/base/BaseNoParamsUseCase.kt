package com.karthik.poc.ebook.domain.usecase.base

interface BaseNoParamsUseCase<out T> {
    suspend fun execute(): T
}