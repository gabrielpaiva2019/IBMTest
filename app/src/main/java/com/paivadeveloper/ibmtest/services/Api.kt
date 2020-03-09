package com.paivadeveloper.ibmtest.services

import com.paivadeveloper.ibmtest.model.User
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("/login")
    fun getContacts(): Call<User>
}