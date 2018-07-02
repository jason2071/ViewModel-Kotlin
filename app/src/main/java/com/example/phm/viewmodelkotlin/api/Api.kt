package com.example.phm.viewmodelkotlin.api

import com.example.phm.viewmodelkotlin.model.Hero
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("marvel/")
    fun getHeroes(): Call<List<Hero>>
}