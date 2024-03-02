package com.example.int20h

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.example.int20h.repository.DeviceRepositoryListImpl
import com.example.int20h.service.DeviceService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val deviceService = DeviceService(applicationContext, DeviceRepositoryListImpl())
        val typeItems = deviceService.types
        val typeTextView : AutoCompleteTextView = findViewById(R.id.typeTextView)
        val typeAdapter = ArrayAdapter(this,R.layout.list_item,typeItems)

        typeTextView.setAdapter(typeAdapter)
        typeTextView.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->
            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(this, "Item: $itemSelected", Toast.LENGTH_SHORT).show()
        }

        val brandItems = deviceService.types
        val brandAdapter = ArrayAdapter(this,R.layout.list_item,brandItems)
        val brandTextView : AutoCompleteTextView = findViewById(R.id.brandTextView)
        brandTextView.setAdapter(brandAdapter)
        brandTextView.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, view, i, l ->
            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(this, "Item: $itemSelected", Toast.LENGTH_SHORT).show()
        }
    }
}
