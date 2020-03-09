package com.paivadeveloper.ibmtest.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.paivadeveloper.ibmtest.R

class LoginActivity : AppCompatActivity() {
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        presenter = LoginPresenter()
    }
}
