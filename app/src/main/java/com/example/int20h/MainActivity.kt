package com.example.int20h

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.example.int20h.repository.DeviceRepositoryListImpl
import com.example.int20h.service.DeviceService

class MainActivity : AppCompatActivity() {
    val deviceService = DeviceService(DeviceRepositoryListImpl())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val typeItems = deviceService.types
        val autoComplete : AutoCompleteTextView = findViewById(R.id.auto_complete)
        val typeAdapter = ArrayAdapter(this,R.layout.list_item,typeItems)

        autoComplete.setAdapter(typeAdapter)
        autoComplete.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->

            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(this, "Item: $itemSelected", Toast.LENGTH_SHORT).show()
        }
    }
}
