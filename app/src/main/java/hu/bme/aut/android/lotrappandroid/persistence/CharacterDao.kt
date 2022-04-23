package hu.bme.aut.android.lotrappandroid.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hu.bme.aut.android.lotrappandroid.model.Character

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacterList(posters: List<Character>)

    @Query("SELECT * FROM Character WHERE id = :id_")
    suspend fun getCharacter(id_: Long): Character?

    @Query("SELECT * FROM Character")
    suspend fun getCharacterList(): List<Character>
}