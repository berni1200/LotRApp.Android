package hu.bme.aut.android.lotrappandroid.network.dto

import hu.bme.aut.android.lotrappandroid.model.Character


data class CharacterResponseDTO (
    val docs: List<CharacterDTO>,
    val total: Int,
    val limit: Int,
    val offset: Int,
    val page: Int,
    val pages: Int

)

fun CharacterResponseDTO.mapToCharacterList(): List<Character> {
    val characterList : MutableList<Character> = mutableListOf()
    for (d in this.docs){
        characterList.add(Character(
            id = d.id,
            height = d.height,
            race = d.race,
            gender = d.gender,
            birth = d.birth,
            spouse = d.spouse,
            death = d.death,
            realm = d.realm,
            hair = d.hair,
            name = d.name,
            wikiUrl = d.wikiUrl
        ))
    }
    return characterList
}