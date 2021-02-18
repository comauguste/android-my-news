package com.mynews.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ArticleResponse {
    @SerializedName("article")
    @Expose
    var article: Article? = null
}