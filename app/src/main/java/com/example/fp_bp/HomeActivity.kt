package com.example.fp_bp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val home : ImageButton = findViewById(R.id.btnHome)
        home.setOnClickListener {
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
//        blm ada search activity
//        val search : ImageButton = findViewById(R.id.btnSearch)
//        search.setOnClickListener {
//            val intent = Intent(this,SearchActivity::class.java)
//            startActivity(intent)
//        }

        // blm bisa ke fragment account
        val account : ImageButton = findViewById(R.id.btnAccount)
        account.setOnClickListener {
            val intent = Intent(this,AccountFragment::class.java)
            startActivity(intent)
        }
    }
}