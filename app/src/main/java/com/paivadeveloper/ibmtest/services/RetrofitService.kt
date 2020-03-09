package com.paivadeveloper.ibmtest.services

import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object RetrofitService {

    private val retrofit= Retrofit.Builder()
        .baseUrl("https://bank-app-test.herokuapp.com/api")
        .addConverterFactory(JacksonConverterFactory.create())
        .build()

    fun getService(): Api = retrofit.create(
        Api::class.java)
}