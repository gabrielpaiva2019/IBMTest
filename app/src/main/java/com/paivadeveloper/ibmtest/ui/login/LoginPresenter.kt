package com.paivadeveloper.ibmtest.ui.login

import com.paivadeveloper.ibmtest.model.Login
import com.paivadeveloper.ibmtest.model.LoginInfo
import com.paivadeveloper.ibmtest.services.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter : LoginContract.Presenter {
    lateinit var view: LoginContract.View

    override fun attachView(view: LoginContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null!!
    }

    override fun validateDataAndLoginUser(user: String, password: String) {
        val call = RetrofitService.getService().getUser(LoginInfo(user, password))

        call.enqueue(object : Callback<Login> {
            override fun onFailure(call: Call<Login>, t: Throwable) {

            }
            override fun onResponse(
                call: Call<Login>, response: Response<Login>) {
                response.body()?.let { response ->

                    if (response.error.code == 0){

                    }else{

                    }

                }
            }
        })
    }

}
