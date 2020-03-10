package com.paivadeveloper.ibmtest.ui.transaction

import java.text.NumberFormat

class TransactionPresenter : TransactionContract.Presenter {

    lateinit var view: TransactionContract.View


    override fun attachView(view: TransactionContract.View) {
        this.view = view
    }

    override fun detachView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAgencyNumberFormatted(bankAccount: String): String {
        val bankAccountString = bankAccount.toString()
        return bankAccountString.substring(0, 2)+"."+
                bankAccountString.substring(2, bankAccountString.length-1)+"-"+
                bankAccountString.substring(bankAccountString.length-1, bankAccountString.length)
    }

    override fun getBalanceFormatted(balance: Double): String {
       return NumberFormat.getCurrencyInstance().format(balance)
    }
}