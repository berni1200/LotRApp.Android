package hu.bme.aut.android.lotrappandroid.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import hu.bme.aut.android.lotrappandroid.R
import hu.bme.aut.android.lotrappandroid.details.DetailsActivity
import hu.bme.aut.android.lotrappandroid.main.recyclerview.CharacterListAdapter
import hu.bme.aut.android.lotrappandroid.model.LotRCharacter

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), CharacterListAdapter.CharacterListItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CharacterListAdapter
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var list : List<LotRCharacter>

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()

        this.title = "Characters"

        mainViewModel.fetchCharacterList()

        mainViewModel.characterList.observe(this, Observer { newContent ->
            list = newContent
            adapter.update(newContent)
        })

        val filterEditText : EditText = findViewById(R.id.MainFilterEditText)
        val filterButton : Button = findViewById(R.id.MainFilterButton)

        filterButton.setOnClickListener { e ->

            val tempList = mainViewModel.filterCharacterList(filterEditText.text.toString(), list)
            //filterEditText.clearFocus()
            adapter.update(tempList)
        }

    }

    private fun initRecyclerView(){
        recyclerView = findViewById(R.id.MainRecyclerView)
        adapter = CharacterListAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun onItemClicked(item: LotRCharacter?) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.KEY_CHARACTER_ID, item!!.id)
        startActivity(intent)
    }

}