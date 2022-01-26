package com.kroma.kromaapplication.viewmodel.api

import com.kroma.kromaapplication.model.ApiResults
import retrofit2.http.GET

interface ApiService {

    @GET("svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=fEY2wKHFZd0aPuq0m4AHNJGoAvoOk6AY")
    suspend fun getArticles(): ApiResults

}