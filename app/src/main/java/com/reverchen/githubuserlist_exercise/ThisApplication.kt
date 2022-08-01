package com.reverchen.githubuserlist_exercise

import android.app.Application
import com.reverchen.githubuserlist_exercise.retrofit.SealRetrofit
import retrofit2.Retrofit

class ThisApplication : Application() {
    
    companion object {
        private var _lastClickTimeL: Long? = null
        
        fun clickable(): Boolean {
            if (_lastClickTimeL != null)
                if ((System.currentTimeMillis() - _lastClickTimeL!!) < 1000) return false
            
            
            _lastClickTimeL = System.currentTimeMillis()
            return true
        }
        
        var retrofit: Retrofit? = null
            get() {
                if (field == null)
                    retrofit = SealRetrofit().build()
                
                return field
            }
    }
    
}