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
        return bankAccount.substring(0, 2)+"."+
                bankAccount.substring(2, bankAccount.length-1)+"-"+
                bankAccount.substring(bankAccount.length-1, bankAccount.length)
    }

    override fun getBalanceFormatted(balance: Double): String {
       return NumberFormat.getCurrencyInstance().format(balance)
    }
}