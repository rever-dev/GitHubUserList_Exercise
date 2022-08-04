package com.reverchen.githubuserlist_exercise.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.reverchen.githubuserlist_exercise.ThisApplication
import com.reverchen.githubuserlist_exercise.data_bean.UserResponse
import com.reverchen.githubuserlist_exercise.retrofit.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.HttpException

private const val TAG = "UserRepo"

class UserRepo {
    
    suspend fun fetchUsers(since: Int?, page: Int?): List<UserResponse>? {
        
        Log.d(TAG, "fetchUsers request >>> \nsince: $since \npage: $page")
        
        val retrofit = ThisApplication.retrofit
        val service = retrofit?.create(RetrofitService::class.java)
        
        return try {
            val response = service?.fetchUserList(since, page)
            
            Log.d(TAG, "fetchUsers response >>> \n$response")
            
            response
        } catch (e: HttpException) {
            e.printStackTrace()
            emptyList()
        }
    }
    
    fun fetchUsersPaging(): Flow<PagingData<UserResponse>> {
        val pager = Pager(
            config = PagingConfig(50),
            pagingSourceFactory = { UserDataSource() }
        )
        return pager.flow
    }
}