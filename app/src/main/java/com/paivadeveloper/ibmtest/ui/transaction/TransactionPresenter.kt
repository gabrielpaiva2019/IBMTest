package com.paivadeveloper.ibmtest.ui.transaction

import com.paivadeveloper.ibmtest.model.Statement
import com.paivadeveloper.ibmtest.services.RetrofitService
import com.paivadeveloper.ibmtest.util.NetworkUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.NumberFormat

class TransactionPresenter : TransactionContract.Presenter {
    lateinit var view: TransactionContract.View

    override fun attachView(view: TransactionContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null!!
    }

    override fun getAgencyNumberFormatted(agency: String): String {
        return agency.substring(0, 2) + "." +
                agency.substring(2, agency.length - 1) + "-" +
                agency.substring(agency.length - 1, agency.length)
    }

    override fun getBalanceFormatted(balance: Double): String {
        return NumberFormat.getCurrencyInstance().format(balance)
    }

    override fun getStatementList(userId: Int) {
        val call = RetrofitService.getService().getStatements(userId)

        if (NetworkUtil().hasInternetConnection()) {
            call.enqueue(object : Callback<Statement.StatementList> {
                override fun onFailure(call: Call<Statement.StatementList>, t: Throwable) {
                    view.showErrorMessage(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<Statement.StatementList>, response: Response<Statement.StatementList>
                ) {
                    val statementList = response.body()?.statementList

                    response.body()?.let {
                        view.populateRecyclerStatements(statementList!!)
                    }
                }
            })
        } else {
            view.showErrorMessage(ERROR_NO_INTERNET)
        }
    }

    companion object {
        const val ERROR_NO_INTERNET = "Verifique sua conexão com a internet"
    }
}