package com.kroma.kromaapplication.viewmodel.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.kroma.kromaapplication.model.Article


@Dao
interface ArticleDao {

    @Query("SELECT * FROM Article")
    suspend fun getAll(): List<Article>

    @Insert
    suspend fun insertAll(users: List<Article>)

    @Delete
    suspend fun delete(user: Article)

}