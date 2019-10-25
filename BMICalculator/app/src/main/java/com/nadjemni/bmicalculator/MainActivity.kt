package com.nadjemni.bmicalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        actionBar?.setIcon(R.drawable.logo)
        calculateBtn.setOnClickListener {
            if (heightEDTX.text.isNotEmpty() && weightEDTX.text.isNotEmpty()) {
                val weight = weightEDTX.text.toString().toDouble()
                val height = heightEDTX.text.toString().toInt()
                if (weight > 0 && weight < 600 && height >= 50 && height < 2.5) {
                    val intent = Intent(this@MainActivity, ResultActivity::class.java)
                    intent.putExtra("bmi", calculateBMI(weight, height))
                    startActivity(intent)
                } else {
                    showErrorSnack("Incorrect Values")
                }
            } else {
                showErrorSnack("A filed is missing")
            }
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun showErrorSnack(errorMsg: String) {
        val snackbar = Snackbar.make(container, "error : $errorMsg !", Snackbar.LENGTH_LONG)
        snackbar.view.setBackgroundColor(R.color.colorRed)
        snackbar.show()
    }

    private fun calculateBMI(weight: Double, height: Int) =
        (weight / ((height / 100) * (height / 100)))

}
