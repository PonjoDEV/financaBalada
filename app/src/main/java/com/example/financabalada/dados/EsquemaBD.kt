package com.example.financabalada.dados

class EsquemaBD {

    //aqui temos variáveis estáticas da classe
    companion object{
        val NOME_BD:String = "bd_balada"
        val VERSAO:Int = 1
    }

    object tabela_entrada{
        val NOME_TABELA = "entrada"
        val ID_ATT = "id"
        val VALOR_ATT = "valor"
        val DATA_ATT = "data"

        val CRIA_TABELA =   "CREATE TABLE IF NOT EXISTS $NOME_TABELA " +
                            "($ID_ATT INTEGER primary key autoincrement, " +
                            "$VALOR_ATT double " +
                            "$DATA_ATT integer)"
    }
}