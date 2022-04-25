package hu.bme.aut.android.lotrappandroid.main

import hu.bme.aut.android.lotrappandroid.model.Character
import hu.bme.aut.android.lotrappandroid.network.ApiResponse
import hu.bme.aut.android.lotrappandroid.network.provider.NetworkDataSource
import hu.bme.aut.android.lotrappandroid.persistence.CharacterDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainRepository(
    private val characterDao: CharacterDao,
    private val networkDataSource: NetworkDataSource,
    override val coroutineContext: CoroutineContext = Dispatchers.IO
) : CoroutineScope{
    private val _characterList = MutableSharedFlow<List<Character>>(1, 100)
    val characterList : Flow<List<Character>> = _characterList

    fun fetchCharacterList(){
        launch(coroutineContext) {
            _characterList.tryEmit(characterDao.getCharacterList())
            networkDataSource.fetchCharacterList().let {
                if(it is ApiResponse.Success){
                    _characterList.tryEmit(it.data)
                    characterDao.insertCharacterList(it.data)
                }else{
                    //handle_error
                }
            }
        }
    }

}