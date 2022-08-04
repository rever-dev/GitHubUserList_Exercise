package com.reverchen.githubuserlist_exercise.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.reverchen.githubuserlist_exercise.data_bean.UserResponse
import com.reverchen.githubuserlist_exercise.repository.UserRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class UserListViewModel : ViewModel() {
    
    private val _users = MutableLiveData<List<UserResponse>?>()
    val users: LiveData<List<UserResponse>?>
    get() = _users
    
    init {
//        viewModelScope.launch {
//            val response = UserRepo().fetchUsers(null, null)
//            _users.postValue(response)
//        }
    }
    
    fun fetchUserData(): Flow<PagingData<UserResponse>> = UserRepo().fetchUsersPaging().cachedIn(viewModelScope)
}