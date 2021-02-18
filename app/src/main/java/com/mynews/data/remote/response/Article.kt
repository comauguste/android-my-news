package com.mynews.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Article {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("status")
    @Expose
    var status: Int? = null

    @SerializedName("sourceid")
    @Expose
    var sourceid: String? = null

    @SerializedName("sourcename")
    @Expose
    var sourcename: String? = null

    @SerializedName("author")
    @Expose
    var author: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("urlToImage")
    @Expose
    var urlToImage: String? = null

    @SerializedName("publishedAt")
    @Expose
    var publishedAt: String? = null

    @SerializedName("content")
    @Expose
    var content: String? = null

    @SerializedName("created_at")
    @Expose
    var createdAt: String? = null

    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null
}