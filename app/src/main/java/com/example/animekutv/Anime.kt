package com.example.animekutv

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime (
    val name: String,
    val episodes: Int,
    val rating: Double,
    val description: String,
    val photo: String
) : Parcelable