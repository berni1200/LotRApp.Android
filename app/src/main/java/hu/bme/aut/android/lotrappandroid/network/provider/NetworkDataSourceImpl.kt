package hu.bme.aut.android.lotrappandroid.network.provider

import hu.bme.aut.android.lotrappandroid.model.Character
import hu.bme.aut.android.lotrappandroid.network.ApiResponse
import hu.bme.aut.android.lotrappandroid.network.LotRService
import hu.bme.aut.android.lotrappandroid.network.dto.mapToCharacterList
import hu.bme.aut.android.lotrappandroid.network.safeApiCall
import hu.bme.aut.android.lotrappandroid.network.safeMapResultTo

class NetworkDataSourceImpl(
    private val apiService: LotRService
) : NetworkDataSource {
    override suspend fun fetchCharacterList(): ApiResponse<List<Character>> = safeApiCall {
        apiService.fetchCharacterList()
    }.safeMapResultTo {
        it.mapToCharacterList()
    }

    override suspend fun fetchCharacterById(id: String): ApiResponse<Character> = safeApiCall {
        apiService.fetchCharacterById(id)
    }.safeMapResultTo {
        it.mapToCharacterList()[0]
    }
}