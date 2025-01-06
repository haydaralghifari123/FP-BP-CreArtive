package com.example.fp_bp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_settings)

        val btnBack : ImageButton = findViewById(R.id.btnBack6)
        btnBack.setOnClickListener {
            finish()
        }

        val txtEditProfile : TextView = findViewById(R.id.editProfile)
        txtEditProfile.setOnClickListener {
            val intent = Intent(this, Edit_Profile_Activity::class.java)
            startActivity(intent)
        }

        val txtAbout : TextView = findViewById(R.id.about)
        txtAbout.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        val logOut: Button = findViewById(R.id.btnLogout)
        logOut.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}