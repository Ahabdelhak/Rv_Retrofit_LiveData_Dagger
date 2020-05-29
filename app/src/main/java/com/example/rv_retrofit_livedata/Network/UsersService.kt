package com.example.rv_retrofit_livedata.Network

import com.example.rv_retrofit_livedata.Dagger.DaggerApiComponent
import com.example.rv_retrofit_livedata.Model.Data
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