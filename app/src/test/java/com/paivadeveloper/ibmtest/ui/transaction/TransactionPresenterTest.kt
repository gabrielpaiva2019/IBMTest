package com.paivadeveloper.ibmtest.ui.transaction

import com.paivadeveloper.ibmtest.ui.login.LoginActivity
import com.paivadeveloper.ibmtest.ui.login.LoginContract
import com.paivadeveloper.ibmtest.ui.login.LoginPresenter
import io.mockk.MockKAnnotations
import io.mockk.spyk
import junit.framework.TestCase
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
        Assert.assertEquals(presenter.getAgencyNumberFormatted("012314564"), "01.231456-4")
    }

    @Test
    fun testGetBalanceFormatted() {
        Assert.assertEquals(presenter.getBalanceFormatted(200.0), "R\$ 200,00")
    }
}