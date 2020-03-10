package com.paivadeveloper.ibmtest.ui.transaction

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.paivadeveloper.ibmtest.R
import com.paivadeveloper.ibmtest.model.UserAccount
import com.paivadeveloper.ibmtest.util.Constants.Companion.USER_ACCOUNT_KEY
import kotlinx.android.synthetic.main.activity_transaction.*
import java.text.NumberFormat

class TransactionActivity : AppCompatActivity() {

    lateinit var userAccount: UserAccount
    lateinit var presenter: TransactionPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)

        getUserAccountInfo()
        populateAccountInfo()
        presenter = TransactionPresenter()

    }

    private fun populateAccountInfo() {
        var balanceFormatted = NumberFormat.getCurrencyInstance().format(userAccount.balance)

        textViewCurrentUserName.text = userAccount.name
        textViewAccountAndAgency.text = (userAccount.agency.toString() + " " + userAccount.bankAccount)
        textViewAccountBalanceValue.text = balanceFormatted
    }

    private fun getUserAccountInfo() {
        userAccount = intent.extras?.getSerializable(USER_ACCOUNT_KEY) as UserAccount
    }

}
