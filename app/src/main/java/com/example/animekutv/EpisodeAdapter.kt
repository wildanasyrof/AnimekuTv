package com.example.animekutv

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.animekutv.databinding.EpisodeViewBinding

class EpisodeAdapter(private val listEpisode: ArrayList<Int>) : RecyclerView.Adapter<EpisodeAdapter.ListViewHolder>() {

    class ListViewHolder(var binding: EpisodeViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = EpisodeViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listEpisode.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val episode = listEpisode[position]
        holder.binding.tvEpisode.text = episode.toString()
//        Log.d("WOI", episode.toString())

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Episode : ${episode.toString()}\nMaaf server offline :)", Toast.LENGTH_SHORT).show()
        }
    }
}