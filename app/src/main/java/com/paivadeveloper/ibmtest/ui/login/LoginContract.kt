package com.paivadeveloper.ibmtest.ui.login

import com.paivadeveloper.ibmtest.base.BasePresenter

interface LoginContract {

    interface View {
        fun showErrorMessage(s: String)

    }

    interface Presenter : BasePresenter<View> {
        fun validateDataAndLoginUser(user: String, password: String)
    }
}