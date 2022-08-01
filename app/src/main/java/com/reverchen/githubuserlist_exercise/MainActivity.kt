package com.reverchen.githubuserlist_exercise

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.reverchen.githubuserlist_exercise.databinding.ActivityMainBinding
import dev.weiqi.resof.stringOf

class MainActivity : AppCompatActivity() {
    
    private lateinit var _binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        _binding.actMainToolbar.title = "User List"
        
        setContentView(_binding.root)
        setSupportActionBar(_binding.actMainToolbar)
    }
}