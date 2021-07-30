package com.example.ecommercesiteforonlineshopping.ui

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.example.ecommercesiteforonlineshopping.R
import kotlinx.android.synthetic.main.activity_theme.*

class ThemeActivity : AppCompatActivity(), SensorEventListener {
    private  val TAG = "ThemeActivity"
    private lateinit var tvAcceleroemter: TextView
    private lateinit var sensorManager: SensorManager
    private var sensor: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme)
        tvAcceleroemter = findViewById(R.id.tvAcceleroemter)
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        btg_theme.addOnButtonCheckedListener { _, selectedBtnId, isChecked ->
            if (isChecked) {
                val theme = when (selectedBtnId) {
                    R.id.btnDefault -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
                    R.id.btnDark -> AppCompatDelegate.MODE_NIGHT_YES
                    else -> AppCompatDelegate.MODE_NIGHT_NO
                }
                Log.d(TAG, "isChecked:$isChecked theme:$theme")
                //                AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM -- default
                //                AppCompatDelegate.MODE_NIGHT_YES -dark
                //                AppCompatDelegate.MODE_NIGHT_NO - light
                AppCompatDelegate.setDefaultNightMode(theme)
            }
        }


        if (!checkSensor())
            return
        else {
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    private fun checkSensor(): Boolean {
        var flag = true
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) == null) {
            flag = false
        }
        return flag
    }

    override fun onSensorChanged(event: SensorEvent?) {
        val values = event!!.values
        val xAxis = values[0]
        val yAxis = values[1]
        val zAxis = values[2]

        tvAcceleroemter.text = "x: $xAxis , y: $yAxis , z: $zAxis"
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }
}

