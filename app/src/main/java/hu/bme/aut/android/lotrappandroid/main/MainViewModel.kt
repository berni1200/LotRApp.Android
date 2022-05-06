package hu.bme.aut.android.lotrappandroid.main

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.android.lotrappandroid.model.LotRCharacter
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val mainRepository: MainRepository) : ViewModel(), LifecycleObserver {
    val characterList: LiveData<List<LotRCharacter>> = mainRepository.characterList.asLiveData()

    fun fetchCharacterList(){
        mainRepository.fetchCharacterList()
    }

    fun filterCharacterList(filter: String){
    }
}