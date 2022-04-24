package hu.bme.aut.android.lotrappandroid.details

import hu.bme.aut.android.lotrappandroid.persistence.CharacterDao
import javax.inject.Inject

class DetailsRepository @Inject constructor(
    private val characterDao: CharacterDao
) {
}