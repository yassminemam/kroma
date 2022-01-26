package com.kroma.kromaapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kroma.kromaapplication.model.ApiResults
import com.kroma.kromaapplication.utils.Resource
import com.kroma.kromaapplication.viewmodel.api.ApiHelper
import com.kroma.kromaapplication.viewmodel.local.DatabaseHelper
import kotlinx.coroutines.launch


class SingleNetworkCallViewModel(
    private val apiHelper: ApiHelper,
    private val dbHelper: DatabaseHelper
) : ViewModel() {

    private val apiResults = MutableLiveData<Resource<ApiResults>>()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            apiResults.postValue(Resource.loading(null))
            try {
                val articlesFromApi = apiHelper.getArticles()
                apiResults.postValue(Resource.success(articlesFromApi))
            } catch (e: Exception) {
                apiResults.postValue(Resource.error(e.toString(), null))
            }
        }
    }

    fun getArticles(): LiveData<Resource<ApiResults>> {
        return apiResults
    }

}