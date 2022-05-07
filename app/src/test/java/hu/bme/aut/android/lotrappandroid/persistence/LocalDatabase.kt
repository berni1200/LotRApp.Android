package hu.bme.aut.android.lotrappandroid.persistence

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [26])
abstract class LocalDatabase {
    lateinit var dataBase: AppDatabase

    @Before
    fun initDB(){
        dataBase = Room.inMemoryDatabaseBuilder(getApplicationContext(), AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }

    @After
    fun closeDB(){
        dataBase.close()
    }
}