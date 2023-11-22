package com.example.myapplication.data.service

import com.example.myapplication.data.model.CocktailResponse
import retrofit2.Response
import retrofit2.http.GET

interface CocktailAPI {

    @GET("filter.php?c=Cocktail")
    suspend fun getCocktails(): Response<CocktailResponse>
}