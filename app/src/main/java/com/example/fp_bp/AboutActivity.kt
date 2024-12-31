package com.example.fp_bp

import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)

        val btnBack : ImageButton = findViewById(R.id.btnBack5)
        btnBack.setOnClickListener {
            finish()
        }

        // membuat kata di bold
        val text = "CreArtive is a dynamic platform designed for creators and art enthusiasts to showcase, discover, and connect over unique works of art. Whether you’re into illustrations, manga, novels, or any other form of creative expression, CreArtive offers a space to inspire and be inspired. With an intuitive interface and a vibrant community, we bring together creators from around the world to share their passions and find new opportunities to collaborate and grow."
        val spannableString = SpannableString(text)
        val word = "CreArtive"
        var startIndex = text.indexOf(word)

        while (startIndex != -1) {
            val endIndex = startIndex + word.length
            spannableString.setSpan(StyleSpan(Typeface.BOLD), startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            startIndex = text.indexOf(word, endIndex)
        }

        val textView: TextView = findViewById(R.id.textAbout2)
        textView.text = spannableString

    }
}

