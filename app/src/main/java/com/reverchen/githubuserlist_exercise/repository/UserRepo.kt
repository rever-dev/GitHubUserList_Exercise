package com.reverchen.githubuserlist_exercise.repository

import com.reverchen.githubuserlist_exercise.ThisApplication
import com.reverchen.githubuserlist_exercise.data_bean.UserListResponse
import com.reverchen.githubuserlist_exercise.retrofit.RetrofitService

class UserRepo {
    
    suspend fun fetchUserList(): UserListResponse? {
        val retrofit = ThisApplication.retrofit
        val service = retrofit?.create(RetrofitService::class.java)
        
        return service?.fetchUserList()
    }
}