package hu.bme.aut.android.lotrappandroid.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.bme.aut.android.lotrappandroid.R
import hu.bme.aut.android.lotrappandroid.persistence.AppDatabase
import hu.bme.aut.android.lotrappandroid.persistence.CharacterDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room
            .databaseBuilder(
            application.applicationContext,
            AppDatabase::class.java, "lotr-database"
        )
            .build()
    }

    @Provides
    @Singleton
    fun providePosterDao(appDatabase: AppDatabase): CharacterDao {
        return appDatabase.characterDao()
    }
}