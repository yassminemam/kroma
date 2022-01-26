package com.kroma.kromaapplication.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
@Entity
data class MediaMetadata (

	@SerializedName("url") val url : String,
	@SerializedName("format") val format : String,
	@SerializedName("height") val height : Int,
	@SerializedName("width") val width : Int
)