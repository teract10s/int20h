package com.example.int20h.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.int20h.R

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_activity)
    }

    fun buttonClick(view: View?){
        Log.d("WelcomeActivity", "Button Clicked")
        val intent = Intent(this, DeviceActivity::class.java)
        startActivity(intent)
    }
}