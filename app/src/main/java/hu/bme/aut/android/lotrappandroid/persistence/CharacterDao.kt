package hu.bme.aut.android.lotrappandroid.persistence

import androidx.room.*
import hu.bme.aut.android.lotrappandroid.model.LotRCharacter

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacterList(characters: List<LotRCharacter>)

    @Update(entity = LotRCharacter::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateCharacterList(character: LotRCharacter)

    @Query("SELECT * FROM LotRCharacter WHERE id = :id_")
    suspend fun getCharacter(id_: String): LotRCharacter?

    @Query("SELECT * FROM LotRCharacter")
    suspend fun getCharacterList(): List<LotRCharacter>
}