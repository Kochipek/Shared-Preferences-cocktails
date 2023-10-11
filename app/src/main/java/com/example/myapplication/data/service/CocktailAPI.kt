package com.example.myapplication.data.service

import com.example.myapplication.data.model.CocktailResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface CocktailAPI {

    // endpointi aldim
    @GET("search.php?f=a")

    // suspend function olmasinin sebebi coroutine kullanacagimiz icin
   suspend fun getCocktails(): Response<CocktailResponse>

}