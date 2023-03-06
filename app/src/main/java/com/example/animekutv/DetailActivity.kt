package com.example.animekutv

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animekutv.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso
import kotlin.math.log

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var dataAnimeTemp: Anime
    private val listEpisode = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataAnime = intent.getParcelableExtra("DATA_ANIME") as Anime?

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (dataAnime != null) {
            dataAnimeTemp = dataAnime
            fillArrayList(dataAnime.episodes)
            supportActionBar?.title = dataAnime.name
            Picasso.get().load(dataAnime.photo).into(binding.detailPhoto)
//            binding.tvDetailName.text = dataAnime.name
            binding.tvDetailEps.text = "Episode : " + dataAnime.episodes.toString() + "eps"
            binding.tvDetailRating.text = "Rating : " + dataAnime.rating.toString()
            binding.tvDetailDesc.text = dataAnime.description
            recycleViewSetting()
        }

        binding.detailPhoto.setBackgroundColor(resources.getColor(android.R.color.darker_gray))
    }

    private fun fillArrayList(episode: Int) {
        for (i in 0 until  episode) {
            var epsTemp = (episode - i)
            listEpisode.add(epsTemp)
        }
        Log.d("isi array list", listEpisode.toString())
    }

    private fun recycleViewSetting() {
        binding.rvEpisode.setHasFixedSize(true)
        binding.rvEpisode.layoutManager = GridLayoutManager(this, 5)
        val animeAdapter = EpisodeAdapter(listEpisode)
        binding.rvEpisode.adapter = animeAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu_btn_share_action, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_share -> {
//                val share = Intent.createChooser(Intent().apply {
//                    action = Intent.ACTION_SEND
//                    putExtra(Intent.EXTRA_TEXT, "Title : ${dataAnimeTemp.name}\nEpisode : ${dataAnimeTemp.episodes}eps\nRating : ${dataAnimeTemp.rating}")
//                    putExtra(Intent.EXTRA_TITLE, dataAnimeTemp.name)
//                }, null)
//                startActivity(share)
//
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Title : ${dataAnimeTemp.name}\nEpisode : ${dataAnimeTemp.episodes}eps\nRating : ${dataAnimeTemp.rating}\nSinopsis : ${dataAnimeTemp.description}")
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, dataAnimeTemp.name)
                startActivity(shareIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}