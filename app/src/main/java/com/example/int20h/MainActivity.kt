package com.example.int20h

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        var brandItems = deviceService.brands
        var modelItems = deviceService.models

        val brandTextView : AutoCompleteTextView = findViewById(R.id.brandTextView)
        var brandAdapter = ArrayAdapter(this,R.layout.list_item,brandItems)
        val modelTextView : AutoCompleteTextView = findViewById(R.id.modelTextView)
        var modelAdapter = ArrayAdapter(this,R.layout.list_item,modelItems)

        val typeTextView : AutoCompleteTextView = findViewById(R.id.typeTextView)
        val typeAdapter = ArrayAdapter(this,R.layout.list_item,typeItems)

        typeTextView.setAdapter(typeAdapter)
        typeTextView.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, _, i, _ ->
            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(this, "Item: $itemSelected", Toast.LENGTH_SHORT).show()
            brandItems = deviceService.getBrandsByType(itemSelected.toString())
            brandAdapter = ArrayAdapter(this,R.layout.list_item,brandItems)
            brandTextView.setAdapter(brandAdapter)
        }

        brandTextView.setAdapter(brandAdapter)
        brandTextView.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, _, i, _ ->
            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(this, "Item: $itemSelected", Toast.LENGTH_SHORT).show()
            modelItems = deviceService.getModelsByBrand(itemSelected.toString())
            modelAdapter = ArrayAdapter(this,R.layout.list_item,modelItems)
            modelTextView.setAdapter(modelAdapter)
        }

        modelTextView.setAdapter(modelAdapter)
        modelTextView.onItemClickListener = AdapterView.OnItemClickListener {
                adapterView, _, i, _ ->
            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(this, "Item: $itemSelected", Toast.LENGTH_SHORT).show()
        }


    }


}
