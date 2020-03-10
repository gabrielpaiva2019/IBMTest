package com.paivadeveloper.ibmtest.ui.transaction

class TransactionPresenter: TransactionContract.Presenter {

    lateinit var view: TransactionContract.View


    override fun attachView(view: TransactionContract.View) {
        this.view = view
    }

    override fun detachView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}