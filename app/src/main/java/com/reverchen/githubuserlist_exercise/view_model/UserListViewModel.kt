package com.reverchen.githubuserlist_exercise.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reverchen.githubuserlist_exercise.data_bean.UserListResponse
import com.reverchen.githubuserlist_exercise.repository.UserRepo
import kotlinx.coroutines.launch

class UserListViewModel : ViewModel() {
    
    private val _users: MutableLiveData<UserListResponse?> = MutableLiveData()
    val users: MutableLiveData<UserListResponse?>
        get() = _users
    
    init {
        viewModelScope.launch {
            val response = UserRepo().fetchUserList()
            _users.postValue(response)
        }
    }
}