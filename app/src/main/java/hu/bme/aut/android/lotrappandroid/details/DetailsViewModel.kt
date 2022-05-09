package hu.bme.aut.android.lotrappandroid.details

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.android.lotrappandroid.model.LotRCharacter
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(val detailsRepository: DetailsRepository) : ViewModel(), LifecycleObserver{
    val character: LiveData<LotRCharacter> = detailsRepository.character.asLiveData()

    fun fetchCharacterDetails(id: String){
        detailsRepository.fetchCharacter(id)
    }
}