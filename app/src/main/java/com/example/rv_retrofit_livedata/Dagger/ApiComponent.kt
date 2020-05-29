package com.example.rv_retrofit_livedata.Dagger

import com.example.rv_retrofit_livedata.Network.ApiModule
import com.example.rv_retrofit_livedata.Network.UsersService
import com.example.rv_retrofit_livedata.ViewModel.ListViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service: UsersService)
    fun inject(viewModel: ListViewModel)
}