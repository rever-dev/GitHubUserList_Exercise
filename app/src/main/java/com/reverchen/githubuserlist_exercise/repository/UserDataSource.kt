package com.reverchen.githubuserlist_exercise.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.reverchen.githubuserlist_exercise.data_bean.UserResponse
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class UserDataSource : PagingSource<Int, UserResponse>() {
    
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserResponse> {
        return try {
            val currentPage = params.key ?: 1  //当前页码，若为空则设为1
            val limit = params.loadSize  //每次加载的数目
            val usersRes = UserRepo().fetchUsers(0, limit) ?: emptyList() //网络请求数据
//            val prevKey = if (page > 1) page - 1 else null   //计算上一页的页码
            val prevKey = if (currentPage > 1) currentPage - 1 else null
//            val nextKey = if (usersRes.isNotEmpty()) usersRes.last().id else null //计算下一页的页码
            val nextKey = if (usersRes.isNotEmpty()) currentPage + 1 else null
            
            LoadResult.Page(
                data = usersRes,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: IOException) {
            // IOException for network failures.
            LoadResult.Error(e)
        } catch (e: HttpException) {
            // HttpException for any non-2xx HTTP status codes.
            LoadResult.Error(e)
        }
    }
    
    override fun getRefreshKey(state: PagingState<Int, UserResponse>): Int? {
        return null
    }
    
}