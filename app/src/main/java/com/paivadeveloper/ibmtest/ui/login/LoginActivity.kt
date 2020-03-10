package com.paivadeveloper.ibmtest.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.paivadeveloper.ibmtest.R
import com.paivadeveloper.ibmtest.model.LoginInfo
import com.paivadeveloper.ibmtest.model.UserAccount
import com.paivadeveloper.ibmtest.ui.transaction.TransactionActivity
import com.paivadeveloper.ibmtest.util.Constants.Companion.USER_ACCOUNT_KEY
import com.paivadeveloper.ibmtest.util.MaskUtil
import com.paivadeveloper.ibmtest.util.SecurityUtil
import kotlinx.android.synthetic.main.activity_main.*


class LoginActivity : AppCompatActivity(), LoginContract.View {
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = LoginPresenter()
        initListeners()
        setupEditText()
    }

    private fun setupEditText() {
      MaskUtil.format(editTextUser)
    }

    private fun initListeners() {
        buttonLogin.setOnClickListener {
            presenter.validateDataAndLoginUser(
                editTextUser.text.toString(),
                editTextPassword.text.toString()
            )
        }
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
        presenter.start()
    }

    override fun showErrorMessage(errorMessage: String) {
        val snackbar =
            Snackbar.make(constraintLayoutLogin, errorMessage, Snackbar.LENGTH_SHORT)
        snackbar.show()
    }

    override fun showNextScreenAndSaveUser(loginInfo: LoginInfo, userAccount: UserAccount?) {
        var sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        var editor = sharedPreferences.edit()

        editor.putString(KEY_USER, SecurityUtil.encrypt(loginInfo.user))
        editor.putString(KEY_PASSWORD, SecurityUtil.encrypt(loginInfo.password))
        editor.apply()

        val intent = Intent(this, TransactionActivity::class.java)
        intent.putExtra(USER_ACCOUNT_KEY, userAccount)
        startActivity(intent)
    }

    override fun getUserSaved() {
        val sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val user: String? =
            sharedPreferences.getString(KEY_USER, DEFAULT_VALUE_EMPTY)
        val password: String? =
            sharedPreferences.getString(KEY_PASSWORD, DEFAULT_VALUE_EMPTY)

        if (!password.isNullOrEmpty() && !user.isNullOrEmpty()){
            editTextUser.setText(SecurityUtil.decrypt(user))
            editTextPassword.setText(SecurityUtil.decrypt(password))
        }
    }

    companion object{
        const val SHARED_PREF_NAME = "logged_user"
        const val KEY_USER = "user"
        const val KEY_PASSWORD = "password"
        const val DEFAULT_VALUE_EMPTY = ""
    }

}
