package com.example.farmersapp.dashboard

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.farmersapp.databinding.ActivityCropPredictionBinding
import com.example.farmersapp.ml.CropTfliteModel
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.math.RoundingMode
import java.text.DecimalFormat

class CropPrediction : AppCompatActivity() {

    lateinit var binding: ActivityCropPredictionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCropPredictionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.predictionBtn.setOnClickListener {
            predict()
            hideKeyboard(it)
        }
    }

    private fun hideKeyboard(it: View) {
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
    }

    private fun setPieChart(map: MutableMap<String, Float>) {

        val colors: ArrayList<Int> = ArrayList()

        for (c in ColorTemplate.COLORFUL_COLORS) {
            colors.add(c)
        }
        for (c in ColorTemplate.JOYFUL_COLORS) {
            colors.add(c)
        }
        for (c in ColorTemplate.MATERIAL_COLORS) {
            colors.add(c)
        }
        for (c in ColorTemplate.PASTEL_COLORS) {
            colors.add(c)
        }
        for (c in ColorTemplate.LIBERTY_COLORS) {
            colors.add(c)
        }
        for (c in ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(c)
        }


        val entries: ArrayList<PieEntry> = ArrayList()
        for (i in map) {
            entries.add(PieEntry(i.value, i.key))
        }
        val pieDataSet = PieDataSet(entries, "")
        pieDataSet.colors = colors
        pieDataSet.valueTextSize = 16F
        pieDataSet.valueTextColor = Color.WHITE
        val pieData = PieData(pieDataSet)
        pieData.setValueFormatter(PercentFormatter())



        binding.cropChart.data = pieData
        binding.cropChart.setUsePercentValues(true)
        binding.cropChart.highlightValues(null)
        binding.cropChart.description.isEnabled = false
        binding.cropChart.setDrawEntryLabels(false)
        binding.cropChart.legend.textSize = 16F
        binding.cropChart.legend.formSize = 16F
        binding.cropChart.legend.xEntrySpace = 10F
        binding.cropChart.legend.isWordWrapEnabled = true
        binding.cropChart.invalidate()

        binding.allInputLayout.visibility = View.GONE
        binding.chartLay.visibility = View.VISIBLE

    }

    private fun predict() {

        val model = CropTfliteModel.newInstance(this)

// Creates inputs for reference.
        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 7), DataType.FLOAT32)
        val input = FloatArray(7)
        input[0] = binding.inputN.text.toString().toFloat()
        input[1] = binding.inputP.text.toString().toFloat()
        input[2] = binding.inputK.text.toString().toFloat()
        input[3] = binding.inputT.text.toString().toFloat()
        input[4] = binding.inputH.text.toString().toFloat()
        input[5] = binding.inputPh.text.toString().toFloat()
        input[6] = binding.inputR.text.toString().toFloat()
        inputFeature0.loadArray(input)

// Runs model inference and gets result.
        val outputs = model.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer

        val crops: Array<String> = arrayOf(
            "apple", "banana", "blackgram", "chickpea", "coconut", "coffee",
            "cotton", "grapes", "jute", "kidneybeans", "lentil", "maize", "mango",
            "mothbeans", "mungbean", "muskmelon", "orange", "papaya", "pigeonpeas",
            "pomegranate", "rice", "watermelon"
        )
        val map: MutableMap<String, Float> = HashMap()

        for ((k, i) in outputFeature0.floatArray.withIndex()) {
            val df = DecimalFormat("#.###")
            df.roundingMode = RoundingMode.FLOOR

            if (df.format(i).toFloat() * 100 > 0.1) {
                map[crops[k]] = df.format(i).toFloat() * 100
                Log.d("favour", crops[k] + map[crops[k]])
            }
        }
        setPieChart(map)

// Releases model resources if no longer used.
        model.close()
    }
}