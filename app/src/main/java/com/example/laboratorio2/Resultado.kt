package com.example.laboratorio2
//referencia extraida de: https://codelabs.developers.google.com/codelabs/kotlin-android-training-images-compat/#11

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Resultado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val regresarButton: Button = findViewById(R.id.regresar_button)
        regresarButton.setOnClickListener { finish() }
        resultado()
    }
    private fun resultado() {
        val intent = intent
        val imc = intent.getFloatExtra("IMC", 0.0f)
        val imcText: TextView = findViewById(R.id.imc_text)
        val imcNum:Float = String.format("%.1f", imc).toFloat()
        imcText.text = imcNum.toString()
        val resultadoText: TextView = findViewById(R.id.resultado_text)

        val imageView1: ImageView = findViewById(R.id.imageView1)

        when {
            imc < 18.5 -> {
                imageView1.setImageResource(R.drawable.lab21)
                resultadoText.text = "Su peso es inferior al normal"
            }
            imc in 18.5..24.9 -> {
                imageView1.setImageResource(R.drawable.lab22)
                resultadoText.text = "¡Su peso es ideal!"
            }
            imc in 25.0..34.9 -> {
                imageView1.setImageResource(R.drawable.lab23)
                resultadoText.text = "Ustede tiene sobrepeso"
            }
            else -> {
                imageView1.setImageResource(R.drawable.lab24)
                resultadoText.text = "Ustede tiene obesida mórbida"
            }
        }
    }


}
