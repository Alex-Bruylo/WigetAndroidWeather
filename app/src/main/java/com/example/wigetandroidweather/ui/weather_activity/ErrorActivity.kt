package com.example.wigetandroidweather.ui.weather_activity

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import com.example.wigetandroidweather.databinding.ActivityErrorBinding

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ErrorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityErrorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityErrorBinding.inflate(layoutInflater)
        setContentView(binding.root)





    }











}