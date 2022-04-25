package hu.bme.aut.android.lotrappandroid.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.concurrent.Immutable

@Entity
@Immutable
data class Character (
    @PrimaryKey val id: String,
    val height: String,
    val race: String,
    val gender: String,
    val birth: String,
    val spouse: String,
    val death: String,
    val realm: String,
    val hair: String,
    val name: String,
    val wikiUrl: String
)