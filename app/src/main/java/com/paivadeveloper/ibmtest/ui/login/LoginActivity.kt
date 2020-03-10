package com.paivadeveloper.ibmtest.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.paivadeveloper.ibmtest.R
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {
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
    }
}
