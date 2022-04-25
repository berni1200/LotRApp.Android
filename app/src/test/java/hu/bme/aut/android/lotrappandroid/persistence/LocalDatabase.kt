package hu.bme.aut.android.lotrappandroid.persistence

import androidx.room.Room
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith

abstract class LocalDatabase {
    lateinit var dataBase: AppDatabase

    @Before
    fun initDB(){
    }

    @After
    fun closeDB(){
    }
}