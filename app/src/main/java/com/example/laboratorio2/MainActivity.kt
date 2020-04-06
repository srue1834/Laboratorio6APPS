package com.example.laboratorio2
//referencia extraida de: https://codelabs.developers.google.com/codelabs/kotlin-android-training-app-anatomy/#10
//https://zocada.com/using-intents-extras-pass-data-activities-android-beginners-guide/
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val procesarButton: Button = findViewById(R.id.procesar_button)
        val pesoText: TextView = findViewById(R.id.peso_text)

        pesoText.setOnClickListener { toast() }
        procesarButton.setOnClickListener { procesar() }


    }

    private fun procesar() {

        val pesoText: TextView = findViewById(R.id.peso_text)
        var peso:Int = Integer.valueOf(pesoText.text.toString())

        val estaturaText: TextView = findViewById(R.id.estatura_text)
        var estatura:Int = Integer.valueOf(estaturaText.text.toString())


        var converKg:Float = peso*0.4535f

        var converCm:Float = estatura*0.01f
        var imc:Float = converKg/(converCm*converCm)


        val intent = Intent(this, Resultado::class.java)
        intent.putExtra("IMC", imc)

        startActivity(intent)


    }

    private fun toast() {
        Toast.makeText(this, "Ingrese un valor entre 1 y 270",
            Toast.LENGTH_SHORT).show()
    }


}





