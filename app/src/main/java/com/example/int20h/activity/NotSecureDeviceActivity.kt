package com.example.int20h.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.int20h.R
import com.example.int20h.util.CurrentDevice

class NotSecureDeviceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_not_secure_device)
        val device = CurrentDevice.getDevice()
        val model = findViewById<TextView>(R.id.deviceName)
        model.text = device.model
    }

    fun checkNextButtonClick(view: View?){
        val intent = Intent(this, DeviceActivity::class.java)
        startActivity(intent)
    }

    fun moreInfoButtonClick(view: View?){
        val intent = Intent(this, NotSecureMoreInfoDeviceActivity::class.java)
        startActivity(intent)
    }

    fun dataLeaksButtonClick(view: View?){
        val url = CurrentDevice.getDevice().url
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}