package com.example.animekutv

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.animekutv.databinding.ItemViewBinding
import com.squareup.picasso.Picasso

class AnimeAdapter(private val listAnime: ArrayList<Anime>) : RecyclerView.Adapter<AnimeAdapter.ListViewHolder>() {


    class ListViewHolder(var binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listAnime.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, episodes, rating, desc, photo) = listAnime[position]
        Picasso.get().load(photo).into(holder.binding.itemPhoto)
        holder.binding.tvName.text = name
        holder.binding.tvEpisodes.text = "Episodes : " + episodes.toString() + "eps"
        holder.binding.tvRating.text = "Rating : " + rating.toString()

        holder.itemView.setOnClickListener {
//            Toast.makeText(holder.itemView.context, listAnime[holder.adapterPosition].photo, Toast.LENGTH_SHORT).show()
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("DATA_ANIME", listAnime[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }
}