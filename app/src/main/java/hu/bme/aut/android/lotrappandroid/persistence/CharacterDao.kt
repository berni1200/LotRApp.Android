package hu.bme.aut.android.lotrappandroid.persistence

import androidx.room.*
import hu.bme.aut.android.lotrappandroid.model.Character

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacterList(characters: List<Character>)

    @Update(entity = Character::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateCharacterList(character: Character)

    @Query("SELECT * FROM Character WHERE id = :id_")
    suspend fun getCharacter(id_: String): Character?

    @Query("SELECT * FROM Character")
    suspend fun getCharacterList(): List<Character>
}