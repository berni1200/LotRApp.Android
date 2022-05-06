package hu.bme.aut.android.lotrappandroid.network.dto

import hu.bme.aut.android.lotrappandroid.model.LotRCharacter

data class CharacterDTO (
    var id: String?,
    val height: String?,
    val race: String?,
    val gender: String?,
    val birth: String?,
    val spouse: String?,
    val death: String?,
    val realm: String?,
    val hair: String?,
    val name: String?,
    val wikiUrl: String?
)

fun CharacterDTO.mapToCharacter(): LotRCharacter{
    if(this.id != null)
        this.id = "null"
    return LotRCharacter(
        id = this.id!!,
        height = this.height,
        race = this.race,
        gender = this.gender,
        birth = this.birth,
        spouse = this.spouse,
        death = this.death,
        realm = this.realm,
        hair = this.hair,
        name = this.name,
        wikiUrl = this.wikiUrl
    )
}