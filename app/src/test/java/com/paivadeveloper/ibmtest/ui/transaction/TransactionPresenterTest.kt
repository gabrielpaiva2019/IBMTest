package com.paivadeveloper.ibmtest.ui.transaction

import io.mockk.MockKAnnotations
import io.mockk.spyk
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TransactionPresenterTest {
    var presenter = spyk<TransactionPresenter>()

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true, relaxUnitFun = true)
    }

    @Test
    fun testGetAgencyNumberFormatted() {
        Assert.assertEquals(presenter.getAgencyNumberFormatted(AGENCY_NOT_FORMATTED), AGENCY_FORMATTED)
    }

    @Test
    fun testGetBalanceFormatted() {
        Assert.assertEquals(presenter.getBalanceFormatted(BALANCE_NOT_FORMATTED), BALANCE_FORMATED)
    }

    companion object{
        const val AGENCY_NOT_FORMATTED = "012314564"
        const val AGENCY_FORMATTED = "01.231456-4"
        const val BALANCE_NOT_FORMATTED = 200.0
        const val BALANCE_FORMATED = "R$ 200,00"
    }
}