package com.reverchen.githubuserlist_exercise.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.reverchen.githubuserlist_exercise.R
import com.reverchen.githubuserlist_exercise.data_bean.UserListResponseItem
import com.reverchen.githubuserlist_exercise.databinding.ItemUserListBinding
import dev.weiqi.resof.colorIntOf
import dev.weiqi.resof.drawableOf

class UserListAdapter :
    ListAdapter<UserListResponseItem, UserListAdapter.ViewHolder>(DiffCallback()) {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_user_list, parent, false)
        )
        
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = currentList[position]
        holder._binding.itemUserListTvName.text = data.login
        holder._binding.itemUserListTvIdentity.text = if (data.siteAdmin) "admin" else "normal user"
        holder._binding.itemUserListTvIdentity.setBackgroundColor(colorIntOf(R.color.waterGreen))
    }
    
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        
        val _binding: ItemUserListBinding = ItemUserListBinding.bind(view)
    }
    
    class DiffCallback : DiffUtil.ItemCallback<UserListResponseItem>() {
        override fun areItemsTheSame(
            oldItem: UserListResponseItem,
            newItem: UserListResponseItem
        ): Boolean {
            TODO("Not yet implemented")
        }
        
        override fun areContentsTheSame(
            oldItem: UserListResponseItem,
            newItem: UserListResponseItem
        ): Boolean {
            TODO("Not yet implemented")
        }
        
    }
    
    
}