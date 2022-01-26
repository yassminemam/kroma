package com.kroma.kromaapplication.viewmodel.local

import com.kroma.kromaapplication.model.Article


interface DatabaseHelper {

    suspend fun getArticle(): List<Article>

    suspend fun insertAll(users: List<Article>)

}