package com.kroma.kromaapplication.viewmodel.local

import com.kroma.kromaapplication.model.Article

class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {

    override suspend fun getArticle(): List<Article> = appDatabase.articleDao().getAll()

    override suspend fun insertAll(users: List<Article>) = appDatabase.articleDao().insertAll(users)

}