package com.example.animekutv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.animekutv.databinding.ActivityAboutBinding
import com.squareup.picasso.Picasso

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Picasso.get().load(R.drawable.me).into(binding.aboutPhoto)

        supportActionBar?.setTitle("About")
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}