package com.example.myapplication.data.service

// constants file
import com.example.myapplication.Utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {
    // companion object is used to create static variables
    companion object {
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val api: CocktailAPI by lazy {
            retrofit.create(CocktailAPI::class.java)
        }
    }
}