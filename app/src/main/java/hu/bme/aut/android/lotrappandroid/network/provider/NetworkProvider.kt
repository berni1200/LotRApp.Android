package hu.bme.aut.android.lotrappandroid.network.provider

import hu.bme.aut.android.lotrappandroid.model.Character
import hu.bme.aut.android.lotrappandroid.network.ApiResponse

interface NetworkProvider {
    suspend fun fetchCharacterList(): ApiResponse<List<Character>>

    suspend fun fetchCharacterById(id : String) : ApiResponse<Character>
}