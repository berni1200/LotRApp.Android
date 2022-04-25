package hu.bme.aut.android.lotrappandroid.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.bme.aut.android.lotrappandroid.details.DetailsRepository
import hu.bme.aut.android.lotrappandroid.main.Main
import hu.bme.aut.android.lotrappandroid.main.MainRepository
import hu.bme.aut.android.lotrappandroid.network.LotRService
import hu.bme.aut.android.lotrappandroid.network.provider.NetworkDataSource
import hu.bme.aut.android.lotrappandroid.persistence.CharacterDao
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(characterDao: CharacterDao, networkDataSource: NetworkDataSource): MainRepository {
        return MainRepository(characterDao, networkDataSource)
    }

    @Provides
    @Singleton
    fun provideDetailsRepository(characterDao: CharacterDao, networkDataSource: NetworkDataSource): DetailsRepository {
        return DetailsRepository(characterDao, networkDataSource)
    }

}