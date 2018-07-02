package com.example.phm.viewmodelkotlin.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.phm.viewmodelkotlin.api.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


class HeroViewModel() : ViewModel() {

    private var heroList: MutableLiveData<List<Hero>>? = null

    fun getHeroes(): LiveData<List<Hero>> {
        if (heroList == null) {
            heroList = MutableLiveData()
            loadHeroes()
        }

        return heroList as LiveData<List<Hero>>
    }

    private fun loadHeroes() {
        val baseUrl = "https://www.simplifiedcoding.net/demos/"
        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api = retrofit.create(Api::class.java)
        val call = api.getHeroes()

        call.enqueue(object : Callback<List<Hero>> {
            override fun onResponse(call: Call<List<Hero>>, response: Response<List<Hero>>) {
                if (response.isSuccessful) {
                    heroList!!.setValue(response.body())
                    // load success
                } else {
                    try {
                        // load error
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }

                }
            }

            override fun onFailure(call: Call<List<Hero>>, t: Throwable) {
                call.cancel()
                // call failure
            }
        })
    }
}