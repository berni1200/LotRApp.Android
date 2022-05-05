package hu.bme.aut.android.lotrappandroid.main.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.android.lotrappandroid.R
import hu.bme.aut.android.lotrappandroid.model.LotRCharacter

class CharacterListAdapter(private val listener: CharacterListItemClickListener) :
    RecyclerView.Adapter<CharacterListAdapter.CharacterListViewHolder>() {

    private val items = ArrayList<LotRCharacter>()

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : CharacterListViewHolder{
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CharacterListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int){
        val item = items[position]

        holder.item = item
        holder.nameTextView.text = item.name
        holder.raceTextView.text = item.race
    }

    interface CharacterListItemClickListener{
        fun onItemClicked(item: LotRCharacter?)
    }

    inner class CharacterListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var item : LotRCharacter? = null

        var nameTextView : TextView = itemView.findViewById(R.id.NameTextView)
        var raceTextView : TextView = itemView.findViewById(R.id.RaceTextView)
        var itemLayout : LinearLayout = itemView.findViewById(R.id.CharacterListItemLayout)

        init{
            itemLayout.setOnClickListener{listener.onItemClicked(item)}
        }
    }

    fun update(listItems: List<LotRCharacter>){
        items.clear()
        items.addAll(listItems)
        notifyDataSetChanged()
    }

}