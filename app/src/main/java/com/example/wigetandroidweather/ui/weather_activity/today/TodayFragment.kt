package com.example.wigetandroidweather.ui.weather_activity.today

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.wigetandroidweather.data.net.Response
import com.example.wigetandroidweather.databinding.FragmentTodayBinding
import com.example.wigetandroidweather.MainContract
import com.example.wigetandroidweather.R
import com.example.wigetandroidweather.ui.weather_activity.ErrorActivity
import com.example.wigetandroidweather.ui.weather_activity.WeatherActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TodayFragment () : Fragment(),
    MainContract.View.Today {

    private var _binding: FragmentTodayBinding? = null
    @Inject lateinit var todayPr: MainContract.Presinter.Today


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodayBinding.inflate(inflater, container, false)
        val root: View = binding.root
        activity?.setTitle("Today")
        return root
    }

    override fun onStart() {
        super.onStart()
        getData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun getData()
    {

        todayPr.loadDataToday()
    }

    override fun netError(rez:Throwable) {
        val inent=Intent(activity?.applicationContext, ErrorActivity::class.java)
        Log.d("dddd", rez.toString())
        startActivity(inent)
    }

    override fun showLoader() {
        (activity as WeatherActivity).showLoader()
    }

    override fun hideLoader() {
        (activity as WeatherActivity).hideLoader()
    }



    override fun showData(response: Response) {
        binding.apply {
        textViewLocation.text= response.list?.get(0)?.name
        textViewTemperature.text= response.list?.get(0)?.main?.temp.toString()+"\u00B0C"
        textViewWeather.text= response.list?.get(0)?.weather?.get(0)?.description.toString()
        tvWeatherWindyValue.text= response.list?.get(0)?.wind?.speed.toString()+" km/h"
        tvCompassValue.text=response.list?.get(0)?.wind?.deg.toString()+"\u00B0"
        ValuePrecipitation.text=response.list?.get(0)?.clouds.toString()
        ValueUmidity.text= response.list?.get(0)?.rain.toString()
        ValueTempirature.text= response.list?.get(0)?.snow.toString()}

            Glide.with(this)
            .load("https://openweathermap.org/img/wn/"+response.list?.get(0)?.weather?.get(0)?.icon+".png").
                error(R.drawable.ic_launcher_background)
            .into(binding.imageViewWeatherIcon)
    }


    }


