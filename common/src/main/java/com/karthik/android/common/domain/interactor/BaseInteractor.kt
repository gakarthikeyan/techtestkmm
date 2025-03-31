package com.karthik.android.common.domain.interactor

interface BaseInteractor<out T, in Params> {
    suspend fun execute(): T
    suspend fun executeRemote(): T
    suspend fun execute(params: Params){}
}