package com.example.myapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.data.network.ApixuWeatherApiService
import com.example.myapplication.data.network.ConnectivityInterceptorImpl
import com.example.myapplication.data.network.WeatherNetworkDataSourceImpl
import kotlinx.android.synthetic.main.fragment_weather.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WeatherFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val apiService = ApixuWeatherApiService(ConnectivityInterceptorImpl(this.requireContext()))
        val weatherNetworkDataSource = WeatherNetworkDataSourceImpl(apiService)

        weatherNetworkDataSource.downloadedCurrentWeather.observe(viewLifecycleOwner, Observer {
            tvWeather.text = it.currentWeatherEntry.toString() })

        GlobalScope.launch(Dispatchers.Main) {
            //val currentWeatherResponse = apiService.getCurrentWeather("London").await()
            //tvWeather.text = currentWeatherResponse.currentWeatherEntry.toString()
            weatherNetworkDataSource.fetchCurrentWeather("London", "en")
        }
    }
}