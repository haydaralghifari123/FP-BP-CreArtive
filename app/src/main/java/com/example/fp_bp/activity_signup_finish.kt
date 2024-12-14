package com.example.fp_bp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class activity_signup_finish : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_finish)

        // Delay selama 3 detik sebelum pindah ke LoginActivity
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // Mengakhiri SignUp Finish agar tidak kembali saat menekan tombol back
        }, 1000) // Delay 1000 ms = 1 detik

        val textView: TextView = findViewById(R.id.splash_finish)
        val text = "All Done!"
        // make object SpannableString
        val spannableString = SpannableString(text)
        // menetapkan warna putih "All Done".
        // pada karakter 1-8, spasi dihitung
        val white = ForegroundColorSpan(Color.WHITE)
        spannableString.setSpan(white, 0, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        // warna  peach. code ambil dari color.xml
        val peach = ForegroundColorSpan(ContextCompat.getColor(this, R.color.peach))
        spannableString.setSpan(peach, 9, text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.text = spannableString

    }
}