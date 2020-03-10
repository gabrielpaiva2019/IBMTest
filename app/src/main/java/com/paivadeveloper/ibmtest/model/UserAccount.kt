package com.paivadeveloper.ibmtest.model

import java.io.Serializable

data class UserAccount  (val userId : Int, val name : String, val bankAccount : Int, val agency : Int, val balance : Double ): Serializable