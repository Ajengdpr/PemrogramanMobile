package com.example.modul1

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var diceImage1: ImageView
    private lateinit var diceImage2: ImageView
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage1 = findViewById(R.id.dice1)
        diceImage2 = findViewById(R.id.dice2)
        resultText = findViewById(R.id.result_text)
        val rollButton: Button = findViewById(R.id.roll_button)

        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        val dice1 = Random.nextInt(1, 7)
        val dice2 = Random.nextInt(1, 7)

        setDiceImage(diceImage1, dice1)
        setDiceImage(diceImage2, dice2)

        if (dice1 == dice2) {
            resultText.text = "Selamat anda dapat dadu double!"
        } else {
            resultText.text = "Anda belum beruntung!"
        }
    }

    private fun setDiceImage(imageView: ImageView, diceNumber: Int) {
        val drawableResource = when (diceNumber) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            6 -> R.drawable.dice6
            else -> R.drawable.dice_empty
        }
        imageView.setImageResource(drawableResource)
    }
}