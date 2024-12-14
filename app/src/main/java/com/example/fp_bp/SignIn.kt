package com.example.fp_bp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignIn : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)

//        icon Back masih blm bisa di klik, keluar apps terus
//        val btnBack : Button = findViewById(R.id.btnBack5)
//        btnBack.setOnClickListener {
//            //onBackPressedDispatcher.onBackPressed()
//            //finish()
//            try {
//                onBackPressedDispatcher.onBackPressed()
//            } catch (e: Exception) {
//                Log.e("SignIn", "Error in back button")
//            }
//        }

        val btnLogin : Button = findViewById(R.id.buttonLogin)
        btnLogin.setOnClickListener {
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }


    }
}