package hu.bme.aut.android.lotrappandroid.network.provider

import hu.bme.aut.android.lotrappandroid.model.Character
import hu.bme.aut.android.lotrappandroid.network.ApiResponse
import hu.bme.aut.android.lotrappandroid.network.LotRService
import hu.bme.aut.android.lotrappandroid.network.dto.mapToCharacter
import hu.bme.aut.android.lotrappandroid.network.safeApiCall
import hu.bme.aut.android.lotrappandroid.network.safeMapResultTo

class NetworkProviderImpl(
    private val apiService: LotRService
) : NetworkProvider {
    override suspend fun fetchCharacterList(): ApiResponse<List<Character>> = safeApiCall {
        apiService.fetchCharacterList()
    }.safeMapResultTo {
        it.map { it.mapToCharacter() }
    }

    override suspend fun fetchCharacterById(id: String): ApiResponse<Character> = safeApiCall {
        apiService.fetchCharacterById(id)
    }.safeMapResultTo {
        it.mapToCharacter()
    }
}