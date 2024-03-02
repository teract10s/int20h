package com.example.int20h.activity

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.int20h.R
import com.example.int20h.model.Device
import com.example.int20h.repository.DeviceRepositoryListImpl
import com.example.int20h.service.DeviceService
import java.util.Optional

class DeviceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_device)
        val deviceService = DeviceService(applicationContext, DeviceRepositoryListImpl())

        val typeItems = deviceService.types
        var brandItems = deviceService.brands
        var modelItems = deviceService.models

        val brandTextView: AutoCompleteTextView = findViewById(R.id.brandTextView)
        var brandAdapter = ArrayAdapter(this, R.layout.list_item, brandItems)
        val modelTextView: AutoCompleteTextView = findViewById(R.id.modelTextView)
        var modelAdapter = ArrayAdapter(this, R.layout.list_item, modelItems)

        val typeTextView: AutoCompleteTextView = findViewById(R.id.typeTextView)
        val typeAdapter = ArrayAdapter(this, R.layout.list_item, typeItems)

        typeTextView.setAdapter(typeAdapter)
        typeTextView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, _, i, _ ->
            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(this, "Item: $itemSelected", Toast.LENGTH_SHORT).show()
            brandItems = deviceService.getBrandsByType(itemSelected.toString())
            brandAdapter = ArrayAdapter(this, R.layout.list_item, brandItems)
            brandTextView.setAdapter(brandAdapter)
        }

        brandTextView.setAdapter(brandAdapter)
        brandTextView.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, _, i, _ ->
                val itemSelected = adapterView.getItemAtPosition(i)
                Toast.makeText(this, "Item: $itemSelected", Toast.LENGTH_SHORT).show()
                modelItems = deviceService.getModelsByBrand(itemSelected.toString())
                modelAdapter = ArrayAdapter(this, R.layout.list_item, modelItems)
                modelTextView.setAdapter(modelAdapter)
            }

        modelTextView.setAdapter(modelAdapter)
        modelTextView.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, _, i, _ ->
                val itemSelected = adapterView.getItemAtPosition(i)
                Toast.makeText(this, "Item: $itemSelected", Toast.LENGTH_SHORT).show()
            }

        val itemActiveButton = findViewById<Button>(R.id.secondActButton)
        val editText = findViewById<EditText>(R.id.editTextText)
        itemActiveButton.setOnClickListener {
            val device: Optional<Device> = if (editText.text.toString().isNotEmpty()) {
                deviceService.getByModel(editText.text.toString())
            } else {
                deviceService.getByModel(modelTextView.text.toString())
            }
            if (device.isPresent) {
                if (device.get().isSecure) {
                    val intent = Intent(this, ItemInformation::class.java)
                    startActivity(intent)
                } else {
                    val intent = Intent(this, NotSecureDeviceActivity::class.java)
                    startActivity(intent)
                }
            } else {
                val intent = Intent(this, NotFoundDeviceActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
