package hu.bme.aut.android.lotrappandroid.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import hu.bme.aut.android.lotrappandroid.model.LotRCharacter

@Database(entities = [LotRCharacter::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}