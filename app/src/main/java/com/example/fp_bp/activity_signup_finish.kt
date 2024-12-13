package com.example.fp_bp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity


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
    }
}