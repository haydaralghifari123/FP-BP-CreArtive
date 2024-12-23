package com.example.fp_bp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class HomeActivity : AppCompatActivity() {
    private fun replaceFragment(fragment: Fragment) {
        val fragmenManager = supportFragmentManager
        val fragmentTrx = fragmenManager.beginTransaction()
        fragmentTrx.replace(R.id.fragmentContainerView, fragment)
        fragmentTrx.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val btnHome: ImageButton = findViewById(R.id.btnHome)
        val btnSearch: ImageButton = findViewById(R.id.btnSearch)
        val btnAccount: ImageButton = findViewById(R.id.btnAccount)

        //load 1
        replaceFragment(HomeFragment())

        btnHome.setOnClickListener {
            replaceFragment(HomeFragment())
        }

        btnSearch.setOnClickListener {
            replaceFragment(SearchFragment())
        }

        btnAccount.setOnClickListener {
            replaceFragment(AccountFragment())
        }

    }


}