package hu.bme.aut.android.lotrappandroid.network

sealed class ApiResponse<out T : Any> {

    data class Success<out T : Any>(val data: T) : ApiResponse<T>()
    data class Error(val exception: Exception) : ApiResponse<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}

suspend fun <T : Any> safeApiCall(
    call: suspend () -> T
): ApiResponse<T> = try {
    ApiResponse.Success<T>(call.invoke())
} catch (e: Exception) {
    ApiResponse.Error(e)
}

suspend fun <T : Any, R : Any> ApiResponse<T>.safeMapResultTo(
    map: suspend (T) -> R
): ApiResponse<R> = when (this) {
    is ApiResponse.Success -> {
        try {
            ApiResponse.Success<R>(map.invoke(data))
        } catch (e: Exception) {
            ApiResponse.Error(e)
        }
    }
    is ApiResponse.Error -> ApiResponse.Error(exception)
}