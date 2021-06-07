package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/*
 * このActivityでは、ユーザがサイコロを振って、その結果を画面に表示する
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /*
     * サイコロを作成し、結果を受け取って表示する関数
     */
    private fun rollDice() {
        // 6面のサイコロのインスタンスを作成
        val dice = Dice(6)
        // サイコロの目を取得する
        var diceRoll = dice.roll()
        // 結果を表示するTextViewを探す
        val resultTextView: TextView = findViewById(R.id.resultText)
        // サイコロの目をstring型に変換し、TextViewの更新を行う
        resultTextView.text = diceRoll.toString()

        // サイコロの結果に合わせて画像を表示する
        val diceImage: ImageView = findViewById(R.id.diceImage)

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()

    }
}

/*
 * 面の数を受け取って、サイコロを振るクラス
 */
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
