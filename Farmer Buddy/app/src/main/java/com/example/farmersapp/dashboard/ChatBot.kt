package com.example.farmersapp.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.farmersapp.databinding.ActivityChatBotBinding


class ChatBot : AppCompatActivity() {
    lateinit var binding: ActivityChatBotBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBotBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }
}