package com.kroma.kromaapplication.viewmodel.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kroma.kromaapplication.model.Article

@Database(entities = [Article::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao

}