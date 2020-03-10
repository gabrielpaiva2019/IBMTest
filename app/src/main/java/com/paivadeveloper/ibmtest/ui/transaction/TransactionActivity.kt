package com.paivadeveloper.ibmtest.ui.transaction

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

        presenter = TransactionPresenter()
        getUserAccountInfo()
        populateAccountInfo()

    }

    private fun populateAccountInfo() {
        var balanceFormatted = presenter.getBalanceFormatted(userAccount.balance)
        var agencyNumberFormatted = presenter.getAgencyNumberFormatted(userAccount.agency)

        textViewCurrentUserName.text = userAccount.name
        textViewAccountAndAgency.text = getString(R.string.account_info_logged_user, userAccount.bankAccount.toString(),
            agencyNumberFormatted)
        textViewAccountBalanceValue.text = balanceFormatted
    }

    private fun getUserAccountInfo() {
        userAccount = intent.extras?.getSerializable(USER_ACCOUNT_KEY) as UserAccount
    }

}
