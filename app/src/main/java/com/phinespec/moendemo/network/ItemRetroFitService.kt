package com.phinespec.moendemo.network

import retrofit2.http.GET


interface ItemRetroFitService {

    @GET("b/WN0G/")
    suspend fun getAllItems(): retrofit2.Response<com.phinespec.moendemo.model.Response>

}