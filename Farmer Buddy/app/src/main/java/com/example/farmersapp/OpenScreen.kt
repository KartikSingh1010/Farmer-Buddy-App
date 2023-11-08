package com.example.farmersapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.farmersapp.databinding.ActivitySplashBinding


class OpenScreen : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sp1 = applicationContext.getSharedPreferences("myPrefs", MODE_PRIVATE)
        val isOpened = sp1.getBoolean("isIntroOpened", false)

        Handler(Looper.getMainLooper()).postDelayed({
            if(!isOpened) {
                startActivity(Intent(this, IntroActivity::class.java))
            }
            else {
                startActivity(Intent(this, LoginActivity::class.java))
            }
            finish()
        }, 2000)


    }
}