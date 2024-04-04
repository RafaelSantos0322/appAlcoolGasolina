package com.rafaelsantosdeveloper.gasougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {
    private lateinit var textInputAlcool : TextInputLayout
    private lateinit var editAlcool : TextInputEditText

    private lateinit var textInputGasolina : TextInputLayout
    private lateinit var editGasolina : TextInputEditText

    private lateinit var btnCalcular : Button
    private lateinit var textResultado : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializarConponenteInterface()
        btnCalcular.setOnClickListener {
            calcularMelhorPreco()
        }


    }

    private fun calcularMelhorPreco() {
            val precoAlcool = editAlcool.text.toString()
            val precoGasolina = editGasolina.text.toString()

            val resultadoValidacao = validarCampos(precoAlcool, precoGasolina)

            if (resultadoValidacao){
                val resultado = precoAlcool.toDouble() / precoGasolina.toDouble()
                if (resultado >= 0.7){
                    textResultado.text = "Melhor usar gasolina"
                } else {
                    textResultado.text = "Melhor usar álcool"
                }
            }

    }

    private fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean {
        textInputAlcool.error = null
        textInputGasolina.error = null

        if (precoAlcool.isNullOrEmpty()){
            textInputAlcool.error = "Digite o preço do álcool"
            return false
        }
        if (precoGasolina.isNullOrEmpty()){
            textInputGasolina.error = "Digite o preço da gásolina"
            return false
        }
        return true
    }

    private fun inicializarConponenteInterface(){
        textInputAlcool = findViewById(R.id.Text_input_alcool)
        editAlcool = findViewById(R.id.EditText_alcool)

        textInputGasolina = findViewById(R.id.Text_input_gasolina)
        editGasolina = findViewById(R.id.EditT_gasolina)

        btnCalcular = findViewById(R.id.btn_calcular)
        textResultado = findViewById(R.id.TV_resultado)

    }
}