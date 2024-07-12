package com.dicoding.mybookapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
    var name: String,
    var description: String,
    var photo: Int
) : Parcelable
