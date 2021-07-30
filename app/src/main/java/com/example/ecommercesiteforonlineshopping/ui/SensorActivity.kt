package com.example.ecommercesiteforonlineshopping.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.ecommercesiteforonlineshopping.R
import com.example.ecommercesiteforonlineshopping.sensor.AccelerometerActivity
import com.example.ecommercesiteforonlineshopping.sensor.CheckSensorActivity
import com.example.ecommercesiteforonlineshopping.sensor.GyroscopeActivity
import com.example.ecommercesiteforonlineshopping.sensor.LightActivity

class SensorActivity : AppCompatActivity() {
    private lateinit var btnShowAllSensors: Button
    private lateinit var btnSLight:Button
    private lateinit var btnAccelerometer:Button
    private lateinit var btnGyro:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor)
        btnShowAllSensors = findViewById(R.id.btnShowAllSensors)
        btnSLight = findViewById(R.id.btnSLight)
        btnAccelerometer = findViewById(R.id.btnAccelerometer)
        btnGyro = findViewById(R.id.btnGyro)

        btnShowAllSensors.setOnClickListener {
            startActivity(Intent(this, CheckSensorActivity::class.java))
        }
        btnSLight.setOnClickListener {
            startActivity(Intent(this, LightActivity::class.java))
        }

        btnAccelerometer.setOnClickListener {
            startActivity(Intent(this, AccelerometerActivity::class.java))
        }
        btnGyro.setOnClickListener {
            startActivity(Intent(this, GyroscopeActivity::class.java))
        }
    }
}