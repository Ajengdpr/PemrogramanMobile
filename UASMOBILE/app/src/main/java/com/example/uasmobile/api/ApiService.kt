package com.example.uasmobile.api

import com.example.uasmobile.models.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUsers(): Call<List<User>>
}