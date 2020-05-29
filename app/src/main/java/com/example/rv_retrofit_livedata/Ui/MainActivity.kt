package com.example.rv_retrofit_livedata.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rv_retrofit_livedata.Adapter.UserListAdapter
import com.example.rv_retrofit_livedata.R
import com.example.rv_retrofit_livedata.ViewModel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: ListViewModel
    private val usersAdapter = UserListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()

        usersList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = usersAdapter
        }

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            viewModel.refresh()
        }
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.users.observe(this, Observer { countries ->
            countries?.let {
                usersList.visibility = View.VISIBLE
                usersAdapter.updateUsers(it)
            }
        })
        viewModel.userLoadError.observe(this, Observer { isError ->
            isError?.let { list_error.visibility = if (it) View.VISIBLE else View.GONE }
        })
        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                loading_view.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    list_error.visibility = View.GONE
                    usersList.visibility = View.GONE
                }
            }
        })
    }
}