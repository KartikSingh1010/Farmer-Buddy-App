package com.example.farmersapp.dashboard

import android.annotation.SuppressLint
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.farmersapp.databinding.ActivityWeatherInfoBinding

class WeatherInfo : AppCompatActivity(), SensorEventListener {
    private lateinit var binding: ActivityWeatherInfoBinding
    private lateinit var sensorManager: SensorManager
    private var temperature: Sensor? = null
    private var humidity: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWeatherInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        temperature = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)
        humidity = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY)

        if (temperature == null || humidity == null) {
            Toast.makeText(applicationContext, "Not Supported", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onSensorChanged(p0: SensorEvent?) {
        Log.d("sense" , p0.toString())
        if (p0!!.sensor.type == Sensor.TYPE_AMBIENT_TEMPERATURE) {
            val temp: Float = p0.values!![0]
            binding.TempView.text = "Ambient Temperature: $temp C"
        } else if (p0.sensor.type == Sensor.TYPE_RELATIVE_HUMIDITY) {
            val humid: Float = p0.values!![0]
            binding.HumidView.text = "Relative Humidity: $humid %"
        }

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onResume() {
        // Register a listener for the sensor.
        super.onResume()
        sensorManager.registerListener(this, temperature, SensorManager.SENSOR_DELAY_NORMAL)
        sensorManager.registerListener(this, humidity, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}