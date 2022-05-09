package hu.bme.aut.android.lotrappandroid.network.provider

import hu.bme.aut.android.lotrappandroid.model.LotRCharacter
import hu.bme.aut.android.lotrappandroid.network.ApiResponse

interface NetworkDataSource {
    suspend fun fetchCharacterList(): ApiResponse<List<LotRCharacter>>

    suspend fun fetchCharacterById(id : String) : ApiResponse<LotRCharacter>
}