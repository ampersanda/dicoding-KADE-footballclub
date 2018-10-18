package com.ampersanda.footballclub

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.AnkoContext

class FootballRecyclerAdapter(private var listOfFootballClub : MutableList<FootballClub>, var listener : (FootballClub) -> Unit) : RecyclerView.Adapter<FootballRecyclerAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val imgClubLogo : ImageView = itemView.findViewById(FootballView.clubLogoId)
        private val textClubName : TextView = itemView.findViewById(FootballView.clubNameId)

        fun bind(footballClub : FootballClub, listener: (FootballClub) -> Unit){
            textClubName.text = footballClub.name
            Picasso.get().load(footballClub.image).into(imgClubLogo)

            itemView.setOnClickListener { _ ->
                listener(footballClub)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(FootballView().createView(AnkoContext.create(parent.context, parent)));
    }

    override fun getItemCount(): Int = listOfFootballClub.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listOfFootballClub[position], listener)
    }
}