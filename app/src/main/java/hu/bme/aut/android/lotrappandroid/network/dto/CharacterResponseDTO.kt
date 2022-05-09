package hu.bme.aut.android.lotrappandroid.network.dto

import hu.bme.aut.android.lotrappandroid.model.LotRCharacter


data class CharacterResponseDTO (
    val docs: List<CharacterDTO>?,
    val total: Int?,
    val limit: Int?,
    val offset: Int?,
    val page: Int?,
    val pages: Int?

)

fun CharacterResponseDTO.mapToCharacterList(): List<LotRCharacter> {
    val characterList : MutableList<LotRCharacter> = mutableListOf()
    for (d in this.docs!!){
        if(d._id != null)
        characterList.add(LotRCharacter(
            id = d._id!!,
            height = d.height?: "-",
            race = d.race?: "-",
            gender = d.gender?: "-",
            birth = d.birth?: "-",
            spouse = d.spouse?: "-",
            death = d.death?: "-",
            realm = d.realm?: "-",
            hair = d.hair?: "-",
            name = d.name?: "-",
            wikiUrl = d.wikiUrl?: "-"
        ))
    }
    return characterList
}