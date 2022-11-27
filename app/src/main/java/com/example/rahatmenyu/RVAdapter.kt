package com.example.rahatmenyu

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(private val list: ArrayList<ItemModel>) :
    RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    var onItemClick: ((ItemModel)->Unit)? = null

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val header: TextView
        val description: TextView
        val image: ImageView
        val cardiView: CardView

        init {
            header = view.findViewById(R.id.header)
            description = view.findViewById(R.id.description)
            image = view.findViewById(R.id.image)
            cardiView = view.findViewById(R.id.cardView)

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.card_design, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = list[position]

        viewHolder.header.text = item.itemName
        viewHolder.description.text = item.itemDescription
        viewHolder.image.setImageResource(item.itemImg)
        viewHolder.itemView.setOnClickListener{
            onItemClick?.invoke(item)
        }
    }

    override fun getItemCount() = list.size
}