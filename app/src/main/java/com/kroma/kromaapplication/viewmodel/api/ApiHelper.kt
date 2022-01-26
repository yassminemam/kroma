package com.kroma.kromaapplication.viewmodel.api

import com.kroma.kromaapplication.model.ApiResults

interface ApiHelper {

    suspend fun getArticles(): ApiResults
}