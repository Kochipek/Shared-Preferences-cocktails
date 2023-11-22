package com.example.myapplication.ui.vm


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.CocktailModel
import com.example.myapplication.data.service.ApiService
import kotlinx.coroutines.launch
class FeedVm : ViewModel() {
    var cocktailList = MutableLiveData<List<CocktailModel>>()

    fun getData() {
       viewModelScope.launch{
            val response = ApiService.api.getCocktails()
                if (response.isSuccessful) {
                    cocktailList.value = response.body()?.drinks
                }
            }
        }
    }

