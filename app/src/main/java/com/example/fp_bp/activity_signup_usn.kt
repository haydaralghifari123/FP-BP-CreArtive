package com.example.fp_bp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.example.fp_bp.client.RetrofitClient
import com.example.fp_bp.response.account.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class activity_signup_usn : AppCompatActivity() {

    companion object {
        var email = ""
        var password = ""
        var username = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_usn)

        val btnSignup: Button = findViewById(R.id.buttonNext3)
        btnSignup.setOnClickListener {
            /*btnSignup.setOnClickListener {
                val txtUsername: EditText = findViewById(R.id.editTextUsn)
                username = txtUsername.text.toString()

                val intent = Intent(this, activity_signup_finish::class.java)
                startActivity(intent)
            }*/

            RetrofitClient.instance.postRegister(email, password, username).enqueue(
                object : Callback<RegisterResponse> {
                    override fun onResponse(
                        call: Call<RegisterResponse>,
                        response: Response<RegisterResponse>
                    ) {
                        Log.d("Response", response.body()?.toString() ?: "No body")
                        if (response.isSuccessful) {
                            val account = response.body()
                            if (account?.username !=null) {
                                Toast.makeText(this@activity_signup_usn, "sukses", Toast.LENGTH_SHORT).show()
                                val intentRegister = Intent(this@activity_signup_usn, HomeActivity::class.java)
                                startActivity(intentRegister)
                            } else {
                                Toast.makeText(this@activity_signup_usn, "gagal".orEmpty(), Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(this@activity_signup_usn, "Error: ${response.errorBody()?.string()}", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }

            val btnBack: ImageButton = findViewById(R.id.btnBack3)
            btnBack.setOnClickListener {
                finish()
            }
        }
    }