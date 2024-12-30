package com.example.fp_bp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class activity_signup_pass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_pass)

        val btnSignup : Button = findViewById(R.id.buttonNext2)
        btnSignup.setOnClickListener {
            val txtConfirm: EditText = findViewById(R.id.editTextPass2)
            val txtPassword: EditText = findViewById(R.id.editTextPass)
            if(txtPassword.text.toString()==txtConfirm.text.toString()){
                activity_signup_usn.password= txtPassword.text.toString()
                val intent = Intent(this,activity_signup_usn::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Password tidak sama", Toast.LENGTH_SHORT).show()
            }


        }

        val btnBack : ImageButton = findViewById(R.id.btnBack2)
        btnBack.setOnClickListener {
            finish()
        }
    }
}