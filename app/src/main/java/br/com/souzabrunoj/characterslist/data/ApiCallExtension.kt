package br.com.souzabrunoj.characterslist.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> apiCall(call: suspend () -> T): Result<T> {
    return withContext(Dispatchers.IO) {
        try {
            val response = call()
            withContext(Dispatchers.Main) {
                Result.success(response)
            }
        } catch (t: Throwable) {
            withContext(Dispatchers.Main) {
                Result.failure(t)
            }
        }
    }
}