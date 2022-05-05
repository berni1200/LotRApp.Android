package hu.bme.aut.android.lotrappandroid.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hu.bme.aut.android.lotrappandroid.R

class DetailsActivity : AppCompatActivity() {

    companion object{
        const val KEY_CHARACTER_ID = "characterID"
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val characterId = intent.getStringExtra(KEY_CHARACTER_ID) as String
    }
}