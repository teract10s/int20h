package com.example.int20h.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.int20h.R
import com.example.int20h.util.CurrentDevice

class NotSecureMoreInfoDeviceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_not_secure_more_device)
        val device = CurrentDevice.getDevice()
        findViewById<TextView>(R.id.tableType).text = device.type
        findViewById<TextView>(R.id.tableBrand).text = device.brand
        findViewById<TextView>(R.id.tableModel).text = device.model
        findViewById<TextView>(R.id.tableVideo).text = boolToString(device.isVideoSharing)
        findViewById<TextView>(R.id.tableWiFI).text = boolToString(device.isVideoSharing)
        findViewById<TextView>(R.id.tableSecurity).text = device.securityProtocol
        findViewById<TextView>(R.id.tablePrivacy).text = boolToString(device.isPrivacyShutter)
        findViewById<TextView>(R.id.tableEncryption).text = device.encryption
        findViewById<TextView>(R.id.tableSecure).text = boolToString(device.isSecure)
    }

    fun checkNextButtonClick(view: View?){
        val intent = Intent(this, DeviceActivity::class.java)
        startActivity(intent)
    }

    fun lessInfoButtonClick(view: View?){
        val intent = Intent(this, NotSecureDeviceActivity::class.java)
        startActivity(intent)
    }

    fun dataLeaksButtonClick(view: View?){
        val url = CurrentDevice.getDevice().url
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun boolToString(flag: Boolean): String {
        return if (flag) {
            "Yes"
        } else {
            "No"
        }
    }
}