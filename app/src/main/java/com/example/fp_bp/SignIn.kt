package com.example.fp_bp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fp_bp.client.RetrofitClient
import com.example.fp_bp.response.account.LoginResponse
import com.google.android.gms.common.api.Response

class SignIn : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)

        val email : EditText = findViewById(R.id.editTextUsnSignIn)
        val password : EditText = findViewById(R.id.editTextPassSignIn)
        val btnLogin : Button = findViewById(R.id.buttonLogin)

//        gtw ini dipake engga
//        btnLogin.setOnClickListener {
//            val intent = Intent(this,HomeActivity::class.java)
//            startActivity(intent)
//        }

        // event button Login click
        btnLogin.setOnClickListener {
            var email = email.text.toString().trim()
            var pwd = password.text.toString().trim()
        }

        // cek email not empty
        if (email.isEmpty()) {
            email.error = "Email Required"
            email.requestFocus()
            return@setOnClickListener
        }

        // cek password not empty
        if (pwd.isEmpty()) {
            password.error = "Password Required"
            password.requestFocus()
            return@setOnClickListener
        }

        // get response from REST API (web service)
        RetrofitClient.instance.postLogin(email, pwd).enqueue(
            object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                        val account = response.body()
                        if (account?.success == true) {
                            Toast.makeText(this@SignIn, account?.message.toString(), Toast.LENGTH_SHORT).show()
                            val intentLogin = Intent(this@SignIn, HomeActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this@SignIn, account?.message.toString(), Toast.LENGTH_SHORT).show()
                        }
                }
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                }
            }
        )
}