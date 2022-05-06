package hu.bme.aut.android.lotrappandroid.main

import hu.bme.aut.android.lotrappandroid.model.LotRCharacter
import hu.bme.aut.android.lotrappandroid.network.ApiResponse
import hu.bme.aut.android.lotrappandroid.network.provider.NetworkDataSource
import hu.bme.aut.android.lotrappandroid.persistence.CharacterDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainRepository(
    private val characterDao: CharacterDao,
    private val networkDataSource: NetworkDataSource,
    override val coroutineContext: CoroutineContext = Dispatchers.IO
) : CoroutineScope{
    private var _characterList = MutableSharedFlow<List<LotRCharacter>>(1, 100)
    val characterList : Flow<List<LotRCharacter>> = _characterList

    fun fetchCharacterList(){
        launch(coroutineContext) {
            _characterList.tryEmit(characterDao.getCharacterList())
            networkDataSource.fetchCharacterList().let {
                if(it is ApiResponse.Success){
                    _characterList.tryEmit(it.data)
                    characterDao.insertCharacterList(it.data)
                }else{
                    println(it.toString())
                }
            }
        }
    }

}