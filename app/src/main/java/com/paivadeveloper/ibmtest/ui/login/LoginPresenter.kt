package com.paivadeveloper.ibmtest.ui.login

import com.paivadeveloper.ibmtest.base.BasePresenter

class LoginPresenter: LoginContract.Presenter {
    lateinit var view: LoginContract.View

    override fun attachView(view: LoginContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null!!
    }
}