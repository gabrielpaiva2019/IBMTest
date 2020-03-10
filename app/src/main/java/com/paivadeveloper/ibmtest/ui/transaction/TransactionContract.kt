package com.paivadeveloper.ibmtest.ui.transaction

import com.paivadeveloper.ibmtest.base.BasePresenter

interface TransactionContract {
    interface View {

    }

    interface Presenter : BasePresenter<View> {
        fun getAgencyNumberFormatted(bankAccount: String): String
        fun getBalanceFormatted(balance: Double): String

    }
}