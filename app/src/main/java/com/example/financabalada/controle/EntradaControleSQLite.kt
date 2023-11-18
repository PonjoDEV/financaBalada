package com.example.financabalada.controle

import android.content.Context
import com.example.financabalada.modelo.Entrada
import com.example.financabalada.repository.EntradaRepository

class EntradaControleSQLite(var context: Context) {

    lateinit var repository: EntradaRepository

    init {
        repository = EntradaRepository(context)
    }

    fun salvarEntrada(valor: Double, dataEntrada: String): Boolean {
        if (valor != null && dataEntrada != null) {
            val entrada: Entrada = Entrada(valor, dataEntrada)
            return repository.salvarEntrada(entrada)
        }
        return false
    }
}