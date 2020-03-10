package com.paivadeveloper.ibmtest.ui.login

import com.paivadeveloper.ibmtest.base.BasePresenter
import com.paivadeveloper.ibmtest.model.LoginInfo
import com.paivadeveloper.ibmtest.model.UserAccount

interface LoginContract {

    interface View {
        fun showErrorMessage(s: String)
        fun showNextScreenAndSaveUser(user: LoginInfo, password: UserAccount?)
        fun getUserSaved()
        fun clearEditTextsAndHideProgress()
    }

    interface Presenter : BasePresenter<View> {
        fun validateDataAndLoginUser(user: String, password: String)
        fun start()
    }
}