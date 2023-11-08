package com.example.farmersapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.farmersapp.dashboard.*
import com.example.farmersapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.aboutCropCard.setOnClickListener {
            startActivity(Intent(this, AboutCrop::class.java))
        }
        binding.schemaCard.setOnClickListener {
            startActivity(Intent(this, GovernmentSchemas::class.java))
        }
        binding.chatBotCard.setOnClickListener {
            startActivity(Intent(this, ChatBot::class.java))
        }
        binding.prediction.setOnClickListener {
            startActivity(Intent(this, CropPrediction::class.java))
        }
        binding.moistureCard.setOnClickListener {
            startActivity(Intent(this, SoilMoisture::class.java))
        }
        binding.weatherCard.setOnClickListener {
            startActivity(Intent(this, WeatherInfo::class.java))
        }
    }
}