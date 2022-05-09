package hu.bme.aut.android.lotrappandroid.details

import hu.bme.aut.android.lotrappandroid.model.LotRCharacter
import hu.bme.aut.android.lotrappandroid.network.ApiResponse
import hu.bme.aut.android.lotrappandroid.network.provider.NetworkDataSource
import hu.bme.aut.android.lotrappandroid.persistence.CharacterDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailsRepository(
    private val characterDao: CharacterDao,
    private val networkDataSource: NetworkDataSource,
    override val coroutineContext: CoroutineContext = Dispatchers.IO
) : CoroutineScope {
    private val _character = MutableSharedFlow<LotRCharacter>(1, 100)
    val character : Flow<LotRCharacter> = _character

    fun fetchCharacter(id : String){
        launch(coroutineContext) {
            characterDao.getCharacter(id)?.let { _character.tryEmit(it) }
            networkDataSource.fetchCharacterById(id).let {
                if(it is ApiResponse.Success){
                    _character.tryEmit(it.data)
                    characterDao.updateCharacterList(it.data)
                }else{
                    //handle_error
                }
            }
        }
    }

}