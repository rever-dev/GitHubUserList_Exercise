package com.reverchen.githubuserlist_exercise.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.reverchen.githubuserlist_exercise.R
import com.reverchen.githubuserlist_exercise.data_bean.UserResponse
import com.reverchen.githubuserlist_exercise.databinding.ItemUserListBinding
import dev.weiqi.resof.colorIntOf

class UserListAdapter :
    PagingDataAdapter<UserResponse, UserListAdapter.ViewHolder>(DiffCallback()) {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_user_list, parent, false)
        )
        
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position) ?: return
        holder.bindTo(data)
    }
    
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        
        fun bindTo(data: UserResponse) {
            _binding.apply {
                itemUserListTvName.text = data.login
                itemUserListTvIdentity.text = if (data.siteAdmin) "admin" else "normal user"
                _binding.itemUserListTvIdentity.setBackgroundColor(colorIntOf(R.color.waterGreen))
            }
        }
        
        private val _binding: ItemUserListBinding = ItemUserListBinding.bind(view)
    }
    
    class DiffCallback : DiffUtil.ItemCallback<UserResponse>() {
        override fun areItemsTheSame(
            oldItem: UserResponse,
            newItem: UserResponse
        ): Boolean {
            return oldItem.id == newItem.id
//            return false
        }
        
        override fun areContentsTheSame(
            oldItem: UserResponse,
            newItem: UserResponse
        ): Boolean {
            return oldItem == newItem
//            return false
        }
        
    }
    
    
}