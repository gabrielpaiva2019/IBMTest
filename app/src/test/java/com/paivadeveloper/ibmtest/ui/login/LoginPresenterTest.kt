package com.paivadeveloper.ibmtest.ui.login

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.spyk
import io.mockk.verify
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
        presenter.attachView(view)
    }

    @Test
    fun testValidateContainsSpecialCharacter() {
        assertTrue(presenter.containsSpecialCharacter(PASSWORD_VALID))
    }

    @Test
    fun testNotContinsSpecialCharacter() {
        assertFalse(presenter.containsSpecialCharacter(PASSWORD_WITHOUT_SPECIAL_CHARACTER))
    }

    @Test
    fun testValidateContainsCapitalLetter() {
        assertTrue(presenter.containsCapitalLetter(PASSWORD_VALID))
    }

    @Test
    fun testNotContainsCapitalLetter() {
        assertFalse(presenter.containsCapitalLetter(PASSWORD_WITHOUT_CAPITAL_LETTER))
    }

    @Test
    fun testContainsAlphaNumeric() {
        assertTrue(presenter.containsAlphanumeric(PASSWORD_VALID))
    }

    @Test
    fun testNotContainsAlphaNumeric() {
        assertFalse(presenter.containsAlphanumeric(PASSWORD_WITHOUT_ALPHANUMERIC))
    }

    @Test
    fun testValidateDataAndLoginUser() {
        presenter.validateDataAndLoginUser(USER, PASSWORD_VALID)

        verify { presenter.callLoginService(any(), any()) }
    }

    @Test
    fun testValidateDataAndLoginUserWithEmptyUserAndPassword() {
        every { view.showErrorMessage(any())} answers { nothing }

        presenter.validateDataAndLoginUser(EMPTY_STRING, EMPTY_STRING)

        verify { view.showErrorMessage(any()) }
    }

    @Test
    fun testValidateDataAndLoginUserWithErrorPasswordNoContainsCapitalLetter() {
        every { view.showErrorMessage(any())} answers { nothing }

        presenter.validateDataAndLoginUser(USER, PASSWORD_WITHOUT_CAPITAL_LETTER)

        verify { view.showErrorMessage(any()) }
    }

    @Test
    fun testValidateDataAndLoginUserWithErrorPasswordNoContainsSpecialCharacter() {
        every { view.showErrorMessage(any())} answers { nothing }

        presenter.validateDataAndLoginUser(USER, PASSWORD_WITHOUT_SPECIAL_CHARACTER)

        verify { view.showErrorMessage(any()) }
    }

    @Test
    fun testValidateDataAndLoginUserWithErrorPasswordNoContainsAlphanumeric() {
        every { view.showErrorMessage(any())} answers { nothing }

        presenter.validateDataAndLoginUser(USER, PASSWORD_WITHOUT_ALPHANUMERIC)

        verify { view.showErrorMessage(any()) }
    }


    companion object{
        const val PASSWORD_VALID = "270996bieL$"
        const val USER = "cganasp"
        const val PASSWORD_WITHOUT_SPECIAL_CHARACTER = "aaaAA12"
        const val PASSWORD_WITHOUT_ALPHANUMERIC = "$$$$+Aaaaassds2"
        const val PASSWORD_WITHOUT_CAPITAL_LETTER = "aaa$12"
        const val EMPTY_STRING = ""

    }
}