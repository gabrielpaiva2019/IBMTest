package com.paivadeveloper.ibmtest.model


data class User(var userId: Int = 0,
                var name: String = "",
                var bankAccount: String = "",
                var agency:String = "",
                var balance: Double = 0.0) {
}