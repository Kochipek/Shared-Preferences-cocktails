package com.example.myapplication.ui.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.myapplication.SharedPrefs
import com.example.myapplication.data.model.CocktailModel

class FavScreenVm(private val sharedPrefs: SharedPrefs) : ViewModel() {
    // GET DATA FROM SHARED PREFERENCES
    var favCocktailList = MutableLiveData<List<CocktailModel>>()

    fun getFavData() {
        sharedPrefs.getFavorites()
        favCocktailList.value = sharedPrefs.getFavorites()
    }

    // Factory
    class FavScreenVmFactory(private val sharedPrefs: SharedPrefs) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
            if (modelClass.isAssignableFrom(FavScreenVm::class.java)) {
                return FavScreenVm(sharedPrefs) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
