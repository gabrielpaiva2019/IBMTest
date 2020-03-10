package com.paivadeveloper.ibmtest.ui.transaction

import com.paivadeveloper.ibmtest.base.BasePresenter
import com.paivadeveloper.ibmtest.model.Statement

interface TransactionContract {
    interface View {
        fun populateRecyclerStatements(statementList: MutableList<Statement.StatementItem>)
        fun showErrorMessage(errorNoInternet: String)

    }

    interface Presenter : BasePresenter<View> {
        fun getAgencyNumberFormatted(bankAccount: String): String
        fun getBalanceFormatted(balance: Double): String
        fun getStatementList(userId: Int)

    }
}