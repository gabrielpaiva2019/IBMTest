package com.paivadeveloper.ibmtest.base

interface BasePresenter<V> {
    fun attachView(view: V)
    fun detachView()
}