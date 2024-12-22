package com.example.fp_bp

import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // membuat kata di bold
        val textView: TextView = findViewById(R.id.textAbout2)
        val text = "CreArtive is a dynamic platform designed for creators and art enthusiasts to showcase, discover, and connect over unique works of art. Whether you’re into illustrations, manga, novels, or any other form of creative expression, CreArtive offers a space to inspire and be inspired. With an intuitive."
        val spannable = SpannableString(text)
        val boldStart = text.indexOf("CreArtive")
        val boldEnd = boldStart + "CreArtive".length
        spannable.setSpan(StyleSpan(Typeface.BOLD), boldStart, boldEnd, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.text = spannable
    }
}

// blm dicek dijalankan / make yg while