package com.mynews.data.remote.request

data class CreateUserRequest(
    val email: String,
    val name: String,
    val password: String,
    val password_confirmation: String
)