package com.paivadeveloper.ibmtest.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private val retrofit= Retrofit.Builder()
        .baseUrl("https://bank-app-test.herokuapp.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getService(): Api = retrofit.create(
        Api::class.java)
}