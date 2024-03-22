package com.chefsito.kosmostest.domain.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext


interface BackgroundInterface<INPUT,OUTPUT> {
    suspend fun execute(input: INPUT?= null): Result<OUTPUT>
}

abstract class BackgroundUseCase<INPUT, OUTPUT>(
    private val coroutineDispatcher: CoroutineDispatcher
) : BackgroundInterface<INPUT, OUTPUT> {

    override suspend fun execute(input: INPUT?): Result<OUTPUT> {
        return try {
            val result = withContext(coroutineDispatcher) {
                executeInBackground(input)
            }
            Result.success(result)
        } catch (error: Exception) {
            Result.failure(error)
        } catch (error: Throwable) {
            Result.failure(error)
        }
    }
    abstract suspend fun executeInBackground(input: INPUT? = null): OUTPUT
}
