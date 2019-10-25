package com.nadjemni.bmicalculator

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        skipResultBTN.setOnClickListener {
            startActivity( Intent(this@ResultActivity,  MainActivity::class.java))
        }
        val bmi = intent.getDoubleExtra("bmi", -1.0)
        if (bmi == -1.0) {
            containerL.visibility= View.GONE
        } else {
            bmiValueTV.text=bmi.toString()
                if (bmi < 18.5) {
                    containerL.setBackgroundResource(R.color.colorYellow)
                    bmiFlagImgView.setImageResource(R.drawable.exclamationmark)
                    bmiLabelTV.text="You have an UnderWeight!"
                    commentTV.text="Here are some advices To help you increase your weight"
                    advice1IMG.setImageResource(R.drawable.nowater)
                    advice1TV.text="Don't drink water before meals"
                    advice2IMG.setImageResource(R.drawable.bigmeal)
                    advice2TV.text="Use bigger plates"
                    advice3TV.text="Get quality sleep"

                } else {
                    if (bmi > 25) {
                        containerL.setBackgroundResource(R.color.colorRed)
                        bmiFlagImgView.setImageResource(R.drawable.warning)
                        bmiLabelTV.text="You have an OverWeight!"
                        commentTV.text="Here are some advices To help you decrease your weight"
                        advice1IMG.setImageResource(R.drawable.water)
                        advice1TV.text="Drink water a half hour before meals"
                        advice2IMG.setImageResource(R.drawable.twoeggs)
                        advice2TV.text="Eeat only two meals per day and make sure that they contains a high protein"
                        advice3IMG.setImageResource(R.drawable.nosugar)
                        advice3TV.text="Drink coffee or tea and Avoid sugary food"
                    }
                }
            }
        }
}
