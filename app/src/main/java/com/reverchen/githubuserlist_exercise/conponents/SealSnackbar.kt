package com.reverchen.githubuserlist_exercise.conponents

import android.graphics.Color
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.reverchen.githubuserlist_exercise.R
import dev.weiqi.resof.colorIntOf

class SealSnackbar {
    
    companion object {
        
        fun show(view: View, txtId: Int) {
            Snackbar.make(view, txtId, Snackbar.LENGTH_SHORT)
                .setBackgroundTint(Color.WHITE)
                .setTextColor(colorIntOf(R.color.waterGreen))
                .show()
        }
    }
}