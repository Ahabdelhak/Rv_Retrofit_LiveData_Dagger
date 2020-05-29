package com.example.rv_retrofit_livedata.Dagger

import com.example.rv_retrofit_livedata.Model.Data
import com.example.rv_retrofit_livedata.Network.UsersApi
import io.reactivex.Single
import javax.inject.Inject

class UsersService {
    @Inject
    lateinit var api: UsersApi
    init {
        DaggerApiComponent.create().inject(this)
    }
    fun getUsers(): Single<Data> {
        return api.getUsers()
    }
}