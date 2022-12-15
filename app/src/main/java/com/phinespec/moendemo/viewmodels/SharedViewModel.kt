package com.phinespec.moendemo.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phinespec.moendemo.model.Item
import com.phinespec.moendemo.network.ItemsApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class SharedViewModel: ViewModel() {

    init {
        viewModelScope.launch {
            fetchItemsFromApi()
        }
    }

    private val _currentItem = MutableLiveData<Item>()
    val currentItem: LiveData<Item> = _currentItem

    private val _itemList = MutableLiveData<List<Item>>()
    val itemList: LiveData<List<Item>> = _itemList

    private suspend fun fetchItemsFromApi() {
        try {
            val result = ItemsApi.retrofitService.getAllItems()
            if (result.isSuccessful) {
                result.body()?.items?.let {
                    _itemList.value = it
                }
            }
        } catch (e: HttpException) {
            Log.e(TAG,"There was an error getting a response from the api: $e")
        }
    }

    fun setCurrentItem(item: Item) {
        _currentItem.value = item
    }

    companion object {
        const val TAG = "SharedViewModel"
    }
}