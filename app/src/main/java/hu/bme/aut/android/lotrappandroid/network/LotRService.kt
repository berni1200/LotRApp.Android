package hu.bme.aut.android.lotrappandroid.network

import hu.bme.aut.android.lotrappandroid.network.dto.CharacterResponseDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface LotRService {
    @GET("character")
    suspend fun fetchCharacterList(): CharacterResponseDTO

    @GET("character/{id}")
    suspend fun fetchCharacterById(@Path("id") id : String): CharacterResponseDTO
}