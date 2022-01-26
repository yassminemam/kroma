package com.kroma.kromaapplication.model

import com.google.gson.annotations.SerializedName



data class ApiResults (

	@SerializedName("status") val status : String,
	@SerializedName("copyright") val copyright : String,
	@SerializedName("num_results") val num_results : Int,
	@SerializedName("results") val results : List<Article>
)