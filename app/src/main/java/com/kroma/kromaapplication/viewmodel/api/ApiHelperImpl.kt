package com.kroma.kromaapplication.viewmodel.api

import com.kroma.kromaapplication.model.ApiResults

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {
    override suspend fun getArticles(): ApiResults {
        return apiService.getArticles()
    }

}