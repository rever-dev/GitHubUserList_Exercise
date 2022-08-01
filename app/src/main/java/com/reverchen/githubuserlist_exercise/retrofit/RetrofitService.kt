package com.reverchen.githubuserlist_exercise.retrofit

import com.reverchen.githubuserlist_exercise.data_bean.UserListResponse
import retrofit2.http.GET

interface RetrofitService {
    
    @GET(usersUrl)
    suspend fun fetchUserList(): UserListResponse
}