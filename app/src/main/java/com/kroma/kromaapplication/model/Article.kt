package com.kroma.kromaapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "article")
data class Article @JvmOverloads constructor(
    @PrimaryKey
    @SerializedName("id") var id: Long,
    @SerializedName("uri") var uri: String?,
    @SerializedName("url") var url: String?,
    @SerializedName("asset_id") var asset_id: Long,
    @SerializedName("source") var source: String?,
    @SerializedName("published_date") var published_date: String?,
    @SerializedName("updated") var updated: String?,
    @SerializedName("section") var section: String?,
    @SerializedName("subsection") var subsection: String?,
    @SerializedName("nytdsection") var nytdsection: String?,
    @SerializedName("adx_keywords") var adx_adx_keywordswords: String?,
    @SerializedName("column") var column: String?,
    @SerializedName("byline") var byline: String?,
    @SerializedName("type") var type: String?,
    @SerializedName("title") var title: String?,
    @SerializedName("abstract") var abstract: String?,
    @SerializedName("eta_id") var eta_id: Long,
) {
    constructor() : this(0, "", "", 0, "", "", "", "", "", "", "", "", "", "", "", "", 0)
}