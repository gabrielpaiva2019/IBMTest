package com.paivadeveloper.ibmtest.ui.login

import com.paivadeveloper.ibmtest.model.Login
import com.paivadeveloper.ibmtest.model.LoginInfo
import com.paivadeveloper.ibmtest.services.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Matcher
import java.util.regex.Pattern


class LoginPresenter : LoginContract.Presenter {
    lateinit var view: LoginContract.View

    override fun attachView(view: LoginContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null!!
    }

    override fun validateDataAndLoginUser(user: String, password: String) {
        if (!user.isNullOrEmpty() && !password.isNullOrEmpty()){
            if (!containsCapitalLetter(password)) {
                view.showErrorMessage(NO_CAPITAL_LETTER_ERROR)
            }else if (!containsAlphanumeric(password)){
                view.showErrorMessage(NO_ALPHANUMERIC_ERROR)
            }else if (!containsSpecialCharacter(password)){
                view.showErrorMessage(NO_SPECIAL_CHARACTER_ERROR)
            }else{
                callLoginService(user, password)
            }
        }else{
            view.showErrorMessage(EMPTY_OR_NULL_ERROR)
        }
    }

    private fun callLoginService(user: String, password: String) {
        val call = RetrofitService.getService().getUser(LoginInfo(user, password))

        call.enqueue(object : Callback<Login> {
            override fun onFailure(call: Call<Login>, t: Throwable) {

            }
            override fun onResponse(
                call: Call<Login>, response: Response<Login>) {
                response.body()?.let { response ->

                    if (response.error.code == 0) {

                    } else {

                    }
                }
            }
        })
    }


    fun containsAlphanumeric(password: String): Boolean{
        val digit: Pattern = Pattern.compile("[a-zA-Z0-9]+")
        val hasNumberCharacter: Matcher = digit.matcher(password)
        return hasNumberCharacter.find()
    }

    fun containsSpecialCharacter(password: String): Boolean {
        val special: Pattern = Pattern.compile("[\$&+,:;=\\\\?@#|/'<>.^*()%!-]")
        val hasSpecialCharacter: Matcher = special.matcher(password)
        return hasSpecialCharacter.find()
    }

    fun containsCapitalLetter(password: String): Boolean {
        val letter: Pattern = Pattern.compile("[a-zA-z]")
        val hasCapitalLatter: Matcher = letter.matcher(password)
        return hasCapitalLatter.find()
    }

    companion object{
        private const val NO_CAPITAL_LETTER_ERROR = "A senha deve ter ao menos uma letra maiuscula"
        private const val NO_ALPHANUMERIC_ERROR = "A senha deve combinar letras e números"
        private const val NO_SPECIAL_CHARACTER_ERROR = "A senha deve ter ao menos um caractere especial"
        private const val EMPTY_OR_NULL_ERROR = "Os campos não podem estar vazios"
    }


}
