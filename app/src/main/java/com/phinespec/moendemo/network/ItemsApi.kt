package com.phinespec.moendemo.network


import com.phinespec.moendemo.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ItemsApi {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
    }

    val retrofitService: ItemRetroFitService by lazy {
        retrofit.create(ItemRetroFitService::class.java)
    }
}