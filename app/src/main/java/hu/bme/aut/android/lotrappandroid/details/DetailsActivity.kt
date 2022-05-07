package hu.bme.aut.android.lotrappandroid.details

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.gms.analytics.HitBuilders
import com.google.android.gms.analytics.Tracker
import com.google.firebase.crashlytics.internal.Logger
import dagger.hilt.android.AndroidEntryPoint
import hu.bme.aut.android.lotrappandroid.R
import hu.bme.aut.android.lotrappandroid.analytics.AnalyticsApplication
import hu.bme.aut.android.lotrappandroid.model.LotRCharacter

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    private val detailsViewModel: DetailsViewModel by viewModels()
    private var mTracker: Tracker? = null

    companion object{
        const val KEY_CHARACTER_ID = "characterID"
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val application = application as AnalyticsApplication
        mTracker = application.getDefaultTracker()

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

    override fun onResume() {
        super.onResume()
        Log.i(Logger.TAG, "Setting screen name: DetailsActivity")
        mTracker!!.setScreenName("Image~DetailsActivity")
        mTracker!!.send(HitBuilders.ScreenViewBuilder().build())
    }
}