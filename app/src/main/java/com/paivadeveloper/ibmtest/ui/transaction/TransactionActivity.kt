package com.paivadeveloper.ibmtest.ui.transaction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.paivadeveloper.ibmtest.R
import com.paivadeveloper.ibmtest.model.Statement
import com.paivadeveloper.ibmtest.model.UserAccount
import com.paivadeveloper.ibmtest.util.Constants.Companion.USER_ACCOUNT_KEY
import kotlinx.android.synthetic.main.activity_transaction.*

class TransactionActivity : AppCompatActivity(), TransactionContract.View {

    lateinit var userAccount: UserAccount
    lateinit var presenter: TransactionPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)

        presenter = TransactionPresenter()
        getUserAccountInfo()
        populateAccountInfo()
        presenter.getStatementList(userAccount.userId)

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

    override fun populateRecyclerStatements(statementList: MutableList<Statement.StatementItem>) {

    }

}
