package com.example.elon.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.elon.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Appreance.init(this)
        Handler(Looper.getMainLooper()).postDelayed(Runnable {


            if (Appreance.getLogin()) {

                val intent = Intent(this@MainActivity, DashBoard::class.java)
                startActivity(intent)
                finish()

            } else {
                val intent = Intent(this@MainActivity, LoginScreen::class.java)
                startActivity(intent)
                finish()

            }

        }, 3000)
    }
}
