package com.example.wigetandroidweather.ui.weather_activity

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.wigetandroidweather.MainContract
import com.example.wigetandroidweather.R
import com.example.wigetandroidweather.databinding.ActivityWeatherBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WeatherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment)

       setSupportActionBar(binding.toolbar)
        navView.setupWithNavController(navController)

    }

  fun showLoader() {
    binding.idLoadingContainer.visibility=View.VISIBLE
    }

   fun hideLoader() {
        binding.idLoadingContainer.visibility=View.INVISIBLE
    }
}