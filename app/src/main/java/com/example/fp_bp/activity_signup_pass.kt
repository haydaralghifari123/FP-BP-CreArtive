package com.example.fp_bp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class activity_signup_pass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_pass)

        val btnSignup : Button = findViewById(R.id.buttonNext2)
        btnSignup.setOnClickListener {
            val intent = Intent(this,activity_signup_usn::class.java)
            startActivity(intent)
        }
    }
}