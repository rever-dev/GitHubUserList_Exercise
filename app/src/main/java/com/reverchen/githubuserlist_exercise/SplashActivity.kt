package com.reverchen.githubuserlist_exercise

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.reverchen.githubuserlist_exercise.conponents.SealSnackbar
import com.reverchen.githubuserlist_exercise.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    
    private lateinit var _binding: ActivitySplashBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(_binding.root)
    }
    
    override fun onStart() {
        handleAnimation()
        _binding.actSplBtnContinue.setOnClickListener {
            if (!ThisApplication.clickable()) {
                SealSnackbar.show(it, R.string.try_again_later)
                return@setOnClickListener
            }
            
            it.startAnimation(
                AnimationUtils.loadAnimation(
                    applicationContext,
                    R.anim.translate_horz_out_400_millisec
                ).apply {
                    setAnimationListener(object : Animation.AnimationListener{
                        override fun onAnimationStart(p0: Animation?) {
                        }
    
                        override fun onAnimationEnd(p0: Animation?) {
                            _binding.actSplBtnContinue.visibility = INVISIBLE
                            intentMainActivity()
                        }
    
                        override fun onAnimationRepeat(p0: Animation?) {
                        }
                    })
                })
        }
        super.onStart()
    }
    
    private fun handleAnimation() {
        
        val transAnim =
            AnimationUtils.loadAnimation(applicationContext, R.anim.translate_horz_in_600_millisec)
                .apply {
                    setAnimationListener(object : Animation.AnimationListener {
                        override fun onAnimationStart(p0: Animation?) {
                        }
                        
                        override fun onAnimationEnd(p0: Animation?) {
                            _binding.actSplBtnContinue.visibility = VISIBLE
                        }
                        
                        override fun onAnimationRepeat(p0: Animation?) {
                        }
                    })
                }
        
        val alphaAnim3 =
            AnimationUtils.loadAnimation(applicationContext, R.anim.alpha_show_1000_millisec)
                .apply {
                    setAnimationListener(object : Animation.AnimationListener {
                        override fun onAnimationStart(p0: Animation?) {
                        }
                        
                        override fun onAnimationEnd(p0: Animation?) {
                            _binding.actSplTvExecrise.visibility = VISIBLE
                            _binding.actSplBtnContinue.animation = transAnim
                        }
                        
                        override fun onAnimationRepeat(p0: Animation?) {
                        }
                    })
                }
        
        val alphaAnim2 =
            AnimationUtils.loadAnimation(applicationContext, R.anim.alpha_show_1000_millisec)
                .apply {
                    setAnimationListener(object : Animation.AnimationListener {
                        override fun onAnimationStart(p0: Animation?) {
                        }
                        
                        override fun onAnimationEnd(p0: Animation?) {
                            _binding.actSplTvAppName.visibility = VISIBLE
                            _binding.actSplTvExecrise.animation = alphaAnim3
                        }
                        
                        override fun onAnimationRepeat(p0: Animation?) {
                        }
                    })
                }
        
        val alphaAnim1 =
            AnimationUtils.loadAnimation(applicationContext, R.anim.alpha_show_1000_millisec)
                .apply {
                    setAnimationListener(object : Animation.AnimationListener {
                        override fun onAnimationStart(p0: Animation?) {
                        }
                        
                        override fun onAnimationEnd(p0: Animation?) {
                            _binding.actSplImg.visibility = VISIBLE
                            _binding.actSplTvAppName.animation = alphaAnim2
                        }
                        
                        override fun onAnimationRepeat(p0: Animation?) {
                        }
                    })
                }
        
        _binding.actSplImg.animation = alphaAnim1
    }
    
    private fun intentMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}