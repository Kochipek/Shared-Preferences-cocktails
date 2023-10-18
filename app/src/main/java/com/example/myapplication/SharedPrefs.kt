package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import com.example.myapplication.data.model.CocktailModel
import com.google.gson.Gson

class SharedPrefs(context: Context) {
    private val preferences: SharedPreferences? =
        context.getSharedPreferences("FavoriteStatus", Context.MODE_PRIVATE)


    fun addFavorite(cocktail: CocktailModel) {
        val favorites = getFavorites()
        favorites.add(cocktail)
        saveFavorites(favorites)
    }

    fun removeFavorite(cocktail: CocktailModel) {
        val favorites = getFavorites()
        favorites.remove(cocktail)
        saveFavorites(favorites)
    }

    fun getFavorites(): MutableList<CocktailModel> {
        val json = preferences?.getString("favorites", "[]")
        val favorites = Gson().fromJson(json, Array<CocktailModel>::class.java)
        return favorites?.toMutableList() ?: mutableListOf()
    }

    private fun saveFavorites(favorites: List<CocktailModel>) {
        val json = Gson().toJson(favorites)
        preferences?.edit()?.putString("favorites", json)?.apply()
    }
}
