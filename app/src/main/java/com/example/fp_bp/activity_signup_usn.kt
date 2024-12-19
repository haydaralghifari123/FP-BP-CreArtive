package com.example.fp_bp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.ImageButton

class activity_signup_usn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_usn)

        val btnSignup : Button = findViewById(R.id.buttonNext3)
        btnSignup.setOnClickListener {
            val intent = Intent(this,activity_signup_finish::class.java)
            startActivity(intent)
        }

        val btnBack : ImageButton = findViewById(R.id.btnBack3)
        btnBack.setOnClickListener {
            finish()
        }
    }
}