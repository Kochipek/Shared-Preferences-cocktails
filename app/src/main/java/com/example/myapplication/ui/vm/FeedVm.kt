package com.example.myapplication.ui.vm


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.model.CocktailModel
import com.example.myapplication.data.service.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FeedVm : ViewModel() {
    var cocktailList = MutableLiveData<List<CocktailModel>>()

    fun getData() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = ApiService.api.getCocktails()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    cocktailList.value = response.body()?.drinks
                }
            }
        }
    }
}
