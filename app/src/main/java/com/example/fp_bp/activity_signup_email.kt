package com.example.fp_bp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.EditText
import android.widget.ImageButton

class activity_signup_email : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_email)

        val btnSignup : Button = findViewById(R.id.buttonNext1)
        btnSignup.setOnClickListener {
            val txtEmail:EditText = findViewById(R.id.editTextEmailSignUp)
            activity_signup_usn.email= txtEmail.text.toString()
            val intent = Intent(this,activity_signup_pass::class.java)
            startActivity(intent)
        }

        val btnBack : ImageButton = findViewById(R.id.btnBack1)
        btnBack.setOnClickListener {
            finish()
        }
    }
}