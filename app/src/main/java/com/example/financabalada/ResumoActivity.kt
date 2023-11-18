package com.example.financabalada

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import com.example.financabalada.controle.EntradaControleSQLite
import com.example.financabalada.databinding.ActivityResumoBinding

class ResumoActivity : AppCompatActivity(), OnClickListener{

    lateinit var binding:ActivityResumoBinding
    lateinit var entradaControle:EntradaControleSQLite

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityResumoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_resumo)
        this.entradaControle = EntradaControleSQLite(baseContext)
        startup()
    }

    private fun startup() {
        binding.voltarButton.setOnClickListener(this)
    }

    override fun onClick(bt: View) {
        when(bt.id) {
            binding.voltarButton.id -> {
                voltar()
            }
        }
    }

    private fun voltar() {
        val transicaoInicial:Intent = Intent(baseContext, MainActivity::class.java)
        startActivity(transicaoInicial)
    }
}