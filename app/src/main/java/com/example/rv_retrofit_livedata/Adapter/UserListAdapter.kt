package com.example.rv_retrofit_livedata.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rv_retrofit_livedata.Model.User
import com.example.rv_retrofit_livedata.R
import com.example.rv_retrofit_livedata.Util.loadImage
import kotlinx.android.synthetic.main.item_user.view.*

//Users is ArrayList
class UserListAdapter(var users: ArrayList<User>) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    fun updateUsers(newUsers: List<User>) {
        users.clear()
        users.addAll(newUsers)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = UserViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
    )
    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }
    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView = view.imageView
        private val userName = view.name
        private val userEmail = view.email
        fun bind(country: User) {
            userName.text = country.firstName + " " + country.lastName
            userEmail.text = country.email
            imageView.loadImage(country.avatar)
        }
    }
}