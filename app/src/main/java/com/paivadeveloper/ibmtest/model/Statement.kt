package com.paivadeveloper.ibmtest.model

class Statement{

    data class StatementItem(
        val title: String,
        val desc: String,
        val date: String,
        val value: Double)

    data class StatementList(var statementList: MutableList<StatementItem>)
}




