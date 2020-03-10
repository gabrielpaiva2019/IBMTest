package com.paivadeveloper.ibmtest.ui.login

import com.paivadeveloper.ibmtest.base.BasePresenter

interface LoginContract {

    interface View {

    }

    interface Presenter : BasePresenter<View> {
        fun validateDataAndLoginUser(user: String, password: String)
    }
}