package com.mynews.data.remote

import androidx.annotation.WorkerThread
import com.mynews.data.remote.request.CreateUserRequest
import com.mynews.data.remote.request.LoginRequest
import com.mynews.data.remote.response.*
import retrofit2.Response
import retrofit2.http.*

interface MyNewsApi {
    @WorkerThread
    @GET("/api/articles")
    suspend fun getArticles(): Response<ArticlesResponse>

    @WorkerThread
    @GET("/api/articles/{id}")
    suspend fun getArticleDetail(@Path("id") id: String): Response<ArticleResponse>

    @WorkerThread
    @POST("/api/register")
    suspend fun registerUser(@Body createUserRequest: CreateUserRequest): Response<CreatedUserResponse>


    @WorkerThread
    @POST("/api/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @WorkerThread
    @POST("/api/logout")
    suspend fun logout(@Header("Authorization") bearerToken: String): Response<LogoutResponse>

    @WorkerThread
    @GET("/api/profile")
    suspend fun getProfile(@Header("Authorization") bearerToken: String): Response<CreatedUserResponse>
}