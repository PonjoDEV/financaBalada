package com.example.financabalada

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.financabalada.databinding.ActivityMainBinding
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import com.example.financabalada.controle.EntradaControleSQLite

class MainActivity : AppCompatActivity(), OnClickListener {
    lateinit var binding: ActivityMainBinding
    lateinit var entradaControle: EntradaControleSQLite

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        entradaControle = EntradaControleSQLite(baseContext)

        startUp()
        //setUpRadioGroup()
    }

    private fun startUp() {
        binding.cadastrarButton.setOnClickListener(this)
        binding.resumoButton.setOnClickListener(this)
        binding.entradaRdButton.setOnClickListener(this)
        binding.saidaRdButton.setOnClickListener(this)
    }

    override fun onClick(bt:View){
        when(bt.id){
            binding.resumoButton.id-> {
                acessarResumo()
            }
            binding.cadastrarButton.id-> {
                cadastrarEntradas()
            }
            binding.entradaRdButton.id-> {
                binding.saidaRdButton.isChecked = false
            }
            binding.saidaRdButton.id-> {
                binding.entradaRdButton.isChecked = false
            }
        }
    }

    private fun cadastrarEntradas() {
        if(this.entradaControle.salvarEntrada(binding.valorTxt.text.toString().toDouble(),binding.dataTxt.text.toString())){
            Toast.makeText(baseContext, "Cadastro realizado", Toast.LENGTH_LONG).show()
        }
    }

    private fun acessarResumo() {
        val trasicaoResumo: Intent = Intent(baseContext, ResumoActivity::class.java)
        startActivity(trasicaoResumo)
    }

}