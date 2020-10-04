package com.example.myapplication.data.network

import com.example.myapplication.data.network.response.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "c0dd1467e357a286660683bb348f2871"

/*
    http://api.weatherstack.com/current
    ? access_key = c0dd1467e357a286660683bb348f2871
    & query = New York
    & lang = en
*/

interface ApixuWeatherApiService {

    @GET("current")
    fun getCurrentWeather(
        @Query("query") location: String,
        @Query("lang") languageCode: String = "en"
    ) : Deferred<CurrentWeatherResponse>

    companion object {
        operator fun invoke(
            //подготовка для dependencies  injection (DI)
        connectivityInterceptor: Interceptor
        ): ApixuWeatherApiService {
           val requestInterceptor = Interceptor { chain ->
               val url = chain.request()
                   .url()
                   .newBuilder()
                   .addQueryParameter("access_key",
                       API_KEY
                   )
                   .build()
               val request = chain.request()
                   .newBuilder()
                   .url(url)
                   .build()

               return@Interceptor chain.proceed(request)
           }
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                //перехватччик отсутствующего интернета
                .addInterceptor(connectivityInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.weatherstack.com/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApixuWeatherApiService::class.java)

        }
    }
}