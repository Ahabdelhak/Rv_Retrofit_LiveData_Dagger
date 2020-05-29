package com.example.rv_retrofit_livedata.Network

import com.example.rv_retrofit_livedata.Model.Data
import io.reactivex.Single
import retrofit2.http.GET

interface UsersApi {

    @GET("users")
    fun getUsers(): Single<Data>
}