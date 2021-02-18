package com.mynews.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ArticlesResponse {
    @SerializedName("articles")
    @Expose
    var articles: List<Article>? = null
}