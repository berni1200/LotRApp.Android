package hu.bme.aut.android.lotrappandroid.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hu.bme.aut.android.lotrappandroid.network.LotRService
import hu.bme.aut.android.lotrappandroid.network.interceptor.addAuthorizationKeyToHeader
import hu.bme.aut.android.lotrappandroid.network.provider.NetworkDataSource
import hu.bme.aut.android.lotrappandroid.network.provider.NetworkDataSourceImpl
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideNetworkProvider(apiService: LotRService): NetworkDataSource {
        return NetworkDataSourceImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(addAuthorizationKeyToHeader())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(
                "https://the-one-api.dev/v2/"
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideDisneyService(retrofit: Retrofit): LotRService {
        return retrofit.create(LotRService::class.java)
    }
}