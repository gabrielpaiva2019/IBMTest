package com.paivadeveloper.ibmtest.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.paivadeveloper.ibmtest.R
import kotlinx.android.synthetic.main.activity_main.*


class LoginActivity : AppCompatActivity(), LoginContract.View {
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListeners()
    }

    private fun initListeners() {
        buttonLogin.setOnClickListener { presenter.validateDataAndLoginUser(editTextUser.text.toString(), editTextPassword.text.toString()) }
    }

    override fun onStart() {
        super.onStart()
        presenter = LoginPresenter()
        presenter.attachView(this)
    }

    override fun showErrorMessage(errorMessage: String) {
        val snackbar =
            Snackbar.make(constraintLayoutLogin, errorMessage, Snackbar.LENGTH_SHORT)
        snackbar.show()
    }
}
