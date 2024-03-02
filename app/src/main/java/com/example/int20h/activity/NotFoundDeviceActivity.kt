package com.example.int20h.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.int20h.R

class NotFoundDeviceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_not_found_device)
    }

    fun buttonClick(view: View?){
        val intent = Intent(this, DeviceActivity::class.java)
        startActivity(intent)
    }
}
