package com.mynews.util

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mynews.data.remote.response.LoginResponse
import com.mynews.data.remote.response.User

class UserHelper constructor(
    private val sharedPreferences: SharedPreferences,
    private val gson: Gson
) {
    private var editor: SharedPreferences.Editor = sharedPreferences.edit()

    var isLoggedIn: Boolean
        get() = sharedPreferences.getBoolean(IS_LOGGED_IN, false)
        set(value) {
            editor.putBoolean(IS_LOGGED_IN, value)
            editor.commit()
        }

    var user: User?
        get() {
            val userJson = sharedPreferences.getString(PREF_KEY_USER, null)
            return if (userJson != null) {
                gson.fromJson<User>(
                    userJson,
                    object : TypeToken<User>() {

                    }.type
                )
            } else null

        }
        set(user) {
            editor.putString(PREF_KEY_USER, gson.toJson(user)).commit()
        }

    var loginResponse: LoginResponse?
        get() {
            val loginResponseJson = sharedPreferences.getString(PREF_KEY_USER, null)
            return if (loginResponseJson != null) {
                gson.fromJson<LoginResponse>(
                    loginResponseJson,
                    object : TypeToken<LoginResponse>() {

                    }.type
                )
            } else null

        }
        set(user) {
            editor.putString(PREF_KEY_LOGIN_RESPONSE, gson.toJson(user)).commit()
        }

    val bearerToken: String
        get() = "Bearer " + loginResponse?.token

    private companion object {
        const val IS_LOGGED_IN = "is_logged_in"
        const val PREF_KEY_USER = "PREF_KEY_USER"
        const val PREF_KEY_LOGIN_RESPONSE = "PREF_KEY_LOGIN_RESPONSE"
    }
}