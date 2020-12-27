package com.hamidreza.mvisample.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hamidreza.mvisample.data.model.User
import com.hamidreza.mvisample.databinding.ItemUserBinding

class UserAdapter : ListAdapter<User,UserAdapter.UserViewHolder>(DiffCallBack()){

    inner class UserViewHolder(val binding:ItemUserBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(user: User){
            binding.apply {
                tvCityName.text = user.city
                tvCompanyName.text = user.companyName
                tvEmail.text = user.email
                tvName.text = user.name
                tvPhone.text = user.phone
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = getItem(position)
        currentUser?.let {
            holder.bind(currentUser)
        }
    }

    class DiffCallBack : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: User, newItem: User) = oldItem == newItem
    }
}