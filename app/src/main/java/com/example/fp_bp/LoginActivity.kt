package com.example.fp_bp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnSignup : Button = findViewById(R.id.buttonSignup)
        btnSignup.setOnClickListener {
            val intent = Intent(this,activity_signup_email::class.java)
            startActivity(intent)
        }

        val btnLogin : Button = findViewById(R.id.buttonLogin)
        btnLogin.setOnClickListener {
            val intent = Intent(this,SignIn::class.java)
            startActivity(intent)
        }
    }
}