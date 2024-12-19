package com.example.fp_bp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fp_bp.client.RetrofitClient
import com.example.fp_bp.response.account.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignIn : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val emailEditText: EditText = findViewById(R.id.editTextUsnSignIn)
        val passwordEditText: EditText = findViewById(R.id.editTextPassSignIn)
        val btnLogin: Button = findViewById(R.id.buttonLogin)

        // event button Login click
        btnLogin.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            // cek email not empty
            if (email.isEmpty()) {
                emailEditText.error = "Email Required"
                emailEditText.requestFocus()
                return@setOnClickListener
            }

            // cek password not empty
            if (password.isEmpty()) {
                passwordEditText.error = "Password Required"
                passwordEditText.requestFocus()
                return@setOnClickListener
            }

            // get response from REST API (web service)
            RetrofitClient.instance.postLogin(email, password).enqueue(
                object : Callback<LoginResponse> {
                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        val account = response.body()
                        if (account?.success == true) {
                            Toast.makeText(this@SignIn, account?.message.toString(), Toast.LENGTH_SHORT).show()
                            val intentLogin = Intent(this@SignIn, HomeActivity::class.java)
                            startActivity(intentLogin)
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

        val btnBack : ImageButton = findViewById(R.id.btnBack5)
        btnBack.setOnClickListener {
            finish()
        }
    }
}
