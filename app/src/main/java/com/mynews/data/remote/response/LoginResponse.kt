package com.mynews.data.remote.response

data class LoginResponse(
    val expires_in: Int,
    val message: String,
    val token: String,
    val token_type: String
)