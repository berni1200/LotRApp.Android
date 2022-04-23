package hu.bme.aut.android.lotrappandroid.network

import hu.bme.aut.android.lotrappandroid.model.Character
import hu.bme.aut.android.lotrappandroid.network.dto.CharacterDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface LotRService {
    @GET("character")
    suspend fun fetchCharacterList(): List<CharacterDTO>

    @GET("character/{id}")
    suspend fun fetchCharacterById(@Path("id") id : String): CharacterDTO
}