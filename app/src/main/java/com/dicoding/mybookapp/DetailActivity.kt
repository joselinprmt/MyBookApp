package com.dicoding.mybookapp

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_BOOK = "key_book"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        enableEdgeToEdge()

        val dataBook = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Book>(KEY_BOOK, Book::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Book>(KEY_BOOK)
        }

        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvDetailDescription: TextView = findViewById(R.id.tv_detail_description)
        val ivDetailPhoto: ImageView = findViewById(R.id.iv_detail_photo)

        if (dataBook != null) {
            tvDetailName.text = dataBook.name
            tvDetailDescription.text = dataBook.description
            ivDetailPhoto.setImageResource(dataBook.photo)
        }

    }
}