package com.example.farmersapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.farmersapp.databinding.ActivityDescriptionBinding
import com.example.farmersapp.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class DescriptionActivity : AppCompatActivity() {
    lateinit var binding:ActivityDescriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.NValue.text = intent.getStringExtra("N")
        binding.PValue.text = intent.getStringExtra("P")
        binding.KValue.text = intent.getStringExtra("K")
        binding.pest.text = intent.getStringExtra("pesticide")
        binding.season.text = intent.getStringExtra("season")

    }
}