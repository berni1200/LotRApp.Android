package hu.bme.aut.android.lotrappandroid.main

import hu.bme.aut.android.lotrappandroid.network.LotRService
import hu.bme.aut.android.lotrappandroid.persistence.CharacterDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val lotrService: LotRService,
    private val characterDao: CharacterDao
) {
}