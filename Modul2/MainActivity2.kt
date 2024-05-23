package com.example.KalkulatorTip

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlin.math.ceil

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up the toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val serviceCostInput: EditText = findViewById(R.id.serviceCostInput)
        val tipPercentageGroup: RadioGroup = findViewById(R.id.tipPercentageGroup)
        val roundTipSwitch: Switch = findViewById(R.id.roundTipSwitch)
        val calculateButton: Button = findViewById(R.id.calculateButton)
        val tipResult: TextView = findViewById(R.id.tipResult)

        calculateButton.setOnClickListener {
            val costString = serviceCostInput.text.toString()
            if (costString.isEmpty()) {
                tipResult.text = "Harap masukkan biaya layanan."
                return@setOnClickListener
            }

            val cost = costString.toDoubleOrNull()
            if (cost == null || cost <= 0) {
                tipResult.text = "Masukkan jumlah yang valid."
                return@setOnClickListener
            }

            val tipPercentage = when (tipPercentageGroup.checkedRadioButtonId) {
                R.id.tip15Percent -> 0.15
                R.id.tip18Percent -> 0.18
                R.id.tip20Percent -> 0.20
                else -> 0.0
            }

            if (tipPercentage == 0.0) {
                tipResult.text = "Pilih persentase tip."
                return@setOnClickListener
            }

            var tip = cost * tipPercentage
            if (roundTipSwitch.isChecked) {
                tip = ceil(tip)
            }

            tipResult.text = "Tip: $%.2f".format(tip)
        }
    }
}