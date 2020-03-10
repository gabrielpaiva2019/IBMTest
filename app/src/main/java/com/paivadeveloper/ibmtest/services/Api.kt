package com.paivadeveloper.ibmtest.services

import com.paivadeveloper.ibmtest.model.Login
import com.paivadeveloper.ibmtest.model.LoginInfo
import com.paivadeveloper.ibmtest.model.Statement
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {

    @POST("login")
    fun getUser(@Body loginInfo: LoginInfo): Call<Login>

    @GET("statements/{idUser}")
    fun getStatements(@Path ("idUser") idUser: Int): Call<Statement.StatementList>
}