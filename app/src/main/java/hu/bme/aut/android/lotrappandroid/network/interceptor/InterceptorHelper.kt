package hu.bme.aut.android.lotrappandroid.network.interceptor

import hu.bme.aut.android.lotrappandroid.BuildConfig
import okhttp3.Interceptor
import okhttp3.Request

fun addAuthorizationKeyToHeader(): Interceptor {
    return Interceptor { chain ->
        val newRequest = chain.request().newBuilder()
        newRequest.header("Authorization", "Bearer ${BuildConfig.API_KEY}")
        chain.proceed(newRequest.build())
    }
}