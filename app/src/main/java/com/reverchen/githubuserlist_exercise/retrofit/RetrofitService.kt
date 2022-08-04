package com.reverchen.githubuserlist_exercise.retrofit

import com.reverchen.githubuserlist_exercise.data_bean.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    
    companion object {
        private const val usersUrl = "/users"
    }
    
    @GET(usersUrl)
    suspend fun fetchUserList(@Query("since") since: Int?, @Query("per_page") page: Int?): List<UserResponse>
}