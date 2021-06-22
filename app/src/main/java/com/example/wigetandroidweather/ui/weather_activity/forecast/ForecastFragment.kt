package com.example.wigetandroidweather.ui.weather_activity.forecast

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.wigetandroidweather.databinding.FragmentForecastBinding
import com.example.wigetandroidweather.MainContract
import com.example.wigetandroidweather.R
import com.example.wigetandroidweather.data.net.ForecastResponse
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ForecastFragment : Fragment(), MainContract.View.Forecast {

    private var _binding: FragmentForecastBinding? = null
    private val binding get() = _binding!!
    @Inject lateinit var forecast: MainContract.Presinter.Forecast

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentForecastBinding.inflate(inflater, container, false)
        val root: View = binding.root
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

    override fun getData() {
      forecast.loadDataForecast()
    }

    override fun netError(e:Throwable) {

    }



    override fun showData(responseForecast: ForecastResponse) {
        setTitleActivity(responseForecast.city?.name.toString())
    }

    override fun setTitleActivity(titile: String) {
        if (titile.length>=3) activity?.setTitle(titile)
    }
}