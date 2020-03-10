package com.paivadeveloper.ibmtest.ui.login

import com.paivadeveloper.ibmtest.util.NetworkUtil
import io.mockk.*
import junit.framework.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class LoginPresenterTest {
    var presenter = spyk<LoginPresenter>()
    var view: LoginContract.View = spyk(LoginActivity())

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true, relaxUnitFun = true)
        presenter.view = view
    }

    @Test
    fun testValidateContainsSpecialCharacter() {
        assertTrue(presenter.containsSpecialCharacter("270996bieL$"))
    }

    @Test
    fun testNotContinsSpecialCharacter() {
        assertFalse(presenter.containsSpecialCharacter("aaaa"))
    }

    @Test
    fun testValidateContainsCapitalLetter() {
        assertTrue(presenter.containsCapitalLetter("270996bieL$"))
    }

    @Test
    fun testNotContainsCapitalLetter() {
        assertFalse(presenter.containsCapitalLetter("aaa"))
    }

    @Test
    fun testContainsAlphaNumeric() {
        assertTrue(presenter.containsAlphanumeric("270996bieL$"))
    }

    @Test
    fun testNotContainsAlphaNumeric() {
        assertFalse(presenter.containsAlphanumeric("$$$$$$$"))
    }

    @Test
    fun testValidateDataAndLoginUser() {
        presenter.validateDataAndLoginUser("cgpaiva", "270996bieL$")

        verify { presenter.callLoginService(any(), any()) }
    }

    @Test
    fun testValidateDataAndLoginUserWithEmptyUserAndPassword() {
        every { view.showErrorMessage(any())} answers { nothing }

        presenter.validateDataAndLoginUser("", "")

        verify { view.showErrorMessage(any()) }
    }

    @Test
    fun testValidateDataAndLoginUserWithErrorPasswordNoContainsCapitalLetter() {
        every { view.showErrorMessage(any())} answers { nothing }

        presenter.validateDataAndLoginUser("cganasp", "aaa$12")

        verify { view.showErrorMessage(any()) }
    }

    @Test
    fun testValidateDataAndLoginUserWithErrorPasswordNoContainsSpecialCharacter() {
        every { view.showErrorMessage(any())} answers { nothing }

        presenter.validateDataAndLoginUser("cganasp", "aaaAA12")

        verify { view.showErrorMessage(any()) }
    }

    @Test
    fun testValidateDataAndLoginUserWithErrorPasswordNoContainsAlphanumeric() {
        every { view.showErrorMessage(any())} answers { nothing }

        presenter.validateDataAndLoginUser("cganasp", "$$$$+Aaaaassds2")

        verify { view.showErrorMessage(any()) }
    }
}