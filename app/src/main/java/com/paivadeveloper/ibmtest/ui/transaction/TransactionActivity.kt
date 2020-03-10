package com.paivadeveloper.ibmtest.ui.transaction

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.paivadeveloper.ibmtest.R
import com.paivadeveloper.ibmtest.model.Statement
import com.paivadeveloper.ibmtest.model.UserAccount
import com.paivadeveloper.ibmtest.ui.login.LoginActivity
import com.paivadeveloper.ibmtest.util.Constants.Companion.USER_ACCOUNT_KEY
import kotlinx.android.synthetic.main.activity_transaction.*


class TransactionActivity : AppCompatActivity(), TransactionContract.View {

    lateinit var userAccount: UserAccount
    lateinit var presenter: TransactionPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)

        presenter = TransactionPresenter()
        presenter.attachView(this)
        getUserAccountInfo()
        populateAccountInfo()
        initListeners()
        presenter.getStatementList(userAccount.userId)

    }

    private fun initListeners() {
        imageViewLogout.setOnClickListener { clearSharedPrefAndLogout() }
    }

    private fun clearSharedPrefAndLogout() {
        val sharedPreferences = getSharedPreferences(LoginActivity.SHARED_PREF_NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().clear().apply()
        this.finish()
    }

    private fun populateAccountInfo() {
        var balanceFormatted = presenter.getBalanceFormatted(userAccount.balance)
        var agencyNumberFormatted = presenter.getAgencyNumberFormatted(userAccount.agency)

        textViewCurrentUserName.text = userAccount.name
        textViewAccountAndAgency.text = getString(
            R.string.account_info_logged_user, userAccount.bankAccount.toString(),
            agencyNumberFormatted)
        textViewAccountBalanceValue.text = balanceFormatted
    }

    private fun getUserAccountInfo() {
        userAccount = intent.extras?.getSerializable(USER_ACCOUNT_KEY) as UserAccount
    }

    override fun populateRecyclerStatements(statementList: MutableList<Statement.StatementItem>) {
        val layoutManager = LinearLayoutManager(this)
        recyclerViewStatements.layoutManager = layoutManager
        recyclerViewStatements.adapter = TransactionAdapter(statementList)
    }

}
