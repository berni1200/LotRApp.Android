package hu.bme.aut.android.lotrappandroid.details

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import hu.bme.aut.android.lotrappandroid.R
import hu.bme.aut.android.lotrappandroid.model.LotRCharacter

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    private val detailsViewModel: DetailsViewModel by viewModels()

    companion object{
        const val KEY_CHARACTER_ID = "characterID"
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val characterId = intent.getStringExtra(KEY_CHARACTER_ID) as String
        detailsViewModel.fetchCharacterDetails(characterId)

        detailsViewModel.character.observe(this, Observer { newContent ->
            fillLayout(newContent)
        })

    }

    private fun fillLayout(character : LotRCharacter){
        val lifetimeValue : TextView = findViewById(R.id.LifetimeValueTextView)
        val genderValue : TextView = findViewById(R.id.GenderValueTextView)
        val raceValue : TextView = findViewById(R.id.RaceValueTextView)
        val heightValue : TextView = findViewById(R.id.HeightValueTextView)
        val realmValue : TextView = findViewById(R.id.RealmValueTextView)
        val spouseValue : TextView = findViewById(R.id.SpouseValueTextView)
        val wikiUrlValue : TextView = findViewById(R.id.WikiUrlValueTextView)

        this.title = character.name?: "Nameless character"

        lifetimeValue.text = character.birth + " - " + character.death
        genderValue.text = character.gender
        raceValue.text = character.race
        heightValue.text = character.height
        realmValue.text = character.realm
        spouseValue.text = character.spouse
        wikiUrlValue.text = character.wikiUrl
        wikiUrlValue.text = character.wikiUrl
    }
}