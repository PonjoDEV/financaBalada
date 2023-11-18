package com.example.financabalada.repository

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.financabalada.dados.EsquemaBD
import com.example.financabalada.dados.MeuBancoSQLite
import com.example.financabalada.modelo.Entrada



class OpenHelper(context: Context) : SQLiteOpenHelper(context, "bd_balada", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(EsquemaBD.tabela_entrada.CRIA_TABELA)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Implemente se necessário
    }
}



class EntradaRepository(var contexto: Context) {

    lateinit var banco: MeuBancoSQLite
    lateinit var conexao: SQLiteDatabase

    init {
        this.banco = MeuBancoSQLite(this.contexto)
        this.conexao = this.banco.writableDatabase
    }

    fun salvarEntrada(entrada: Entrada): Boolean {
        val valores:ContentValues = ContentValues()

        valores.put(EsquemaBD.tabela_entrada.VALOR_ATT, entrada.valor)
        if(entrada.dataentrada!=null) {
            valores.put(EsquemaBD.tabela_entrada.DATA_ATT, entrada.dataentrada!!.toLong())
        }
        return this.conexao.insert(EsquemaBD.tabela_entrada.NOME_TABELA,null,valores) >0
    }

    fun entradasBD():Double?{
        return 30.0
    }

    fun saidsBD():Double?{
        return 10.0
    }

    fun valorTotalBD():Double?{
        val dbHelper = OpenHelper(contexto)
        val db = dbHelper.readableDatabase

        val query = "SELECT SUM(${EsquemaBD.tabela_entrada.VALOR_ATT}) FROM ${EsquemaBD.tabela_entrada.NOME_TABELA}"
        val cursor: Cursor = db.rawQuery(query, null)

        var total = 0.0

        if (cursor.moveToFirst()) {
            total = cursor.getDouble(0)
        }

        cursor.close()
        db.close()

        return total
    }

}