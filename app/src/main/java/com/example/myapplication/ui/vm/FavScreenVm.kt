package com.example.myapplication.ui.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.SharedPrefs
import com.example.myapplication.data.model.CocktailModel

class FavScreenVm(private val sharedPrefs: SharedPrefs) : ViewModel() {
    // GET DATA FROM SHARED PREFERENCES
    var favCocktailList = MutableLiveData<List<CocktailModel>>()
    fun getFavData() {
        sharedPrefs.getFavorites()
        favCocktailList.value = sharedPrefs.getFavorites()
    }
}