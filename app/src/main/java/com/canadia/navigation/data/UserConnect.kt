package com.canadia.navigation.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object UserConnect {

    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserAPI::class.java)
    }
}