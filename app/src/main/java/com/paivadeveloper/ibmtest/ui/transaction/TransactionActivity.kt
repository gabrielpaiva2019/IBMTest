package com.paivadeveloper.ibmtest.ui.transaction

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.paivadeveloper.ibmtest.R
import com.paivadeveloper.ibmtest.model.UserAccount
import com.paivadeveloper.ibmtest.util.Constants.Companion.USER_ACCOUNT_KEY

class TransactionActivity : AppCompatActivity() {

    lateinit var userAccount: UserAccount

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)

        getUserAccountInfo()

    }

    private fun getUserAccountInfo() {
        userAccount = intent.extras?.getSerializable(USER_ACCOUNT_KEY) as UserAccount
    }
}
