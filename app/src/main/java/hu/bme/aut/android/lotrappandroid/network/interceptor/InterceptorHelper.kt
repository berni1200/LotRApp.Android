package hu.bme.aut.android.lotrappandroid.network.interceptor

import okhttp3.Interceptor
import okhttp3.Request

fun addAuthorizationKeyToHeader(): Interceptor {
    return Interceptor { chain ->
        val newRequest = chain.request().newBuilder()
        newRequest.header("Authorization", "Bearer 6janm4OvCJ2VK9Irx_hu")
        chain.proceed(newRequest.build())
    }
}