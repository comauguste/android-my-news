package com.mynews.data.remote

data class NewsArticle(
    val id: String,
    val title: String,
    val description: String,
    val sourcename: String,
    val url: String,
    val urlToImage: String,
    val content: String,
    val author: String,
    val publishedAt: String
)