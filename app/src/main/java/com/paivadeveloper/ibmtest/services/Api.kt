package com.paivadeveloper.ibmtest.services

import com.paivadeveloper.ibmtest.model.Login
import com.paivadeveloper.ibmtest.model.LoginInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {

    @POST("login")
    fun getUser(@Body loginInfo: LoginInfo): Call<Login>
}