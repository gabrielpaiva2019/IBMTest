package com.paivadeveloper.ibmtest.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import java.util.regex.Matcher
import java.util.regex.Pattern

class MaskUtil {
    companion object {
        const val CPF_FORMAT = "###.###.###-##"

        private fun replaceChars(cpfFull : String) : String{
            return cpfFull.replace(".", "").replace("-", "")
                .replace("(", "").replace(")", "")
                .replace("/", "").replace(" ", "")
                .replace("*", "")
        }

        fun format(editText : EditText) : TextWatcher {

            val textWatcher : TextWatcher = object : TextWatcher {
                var isUpdating : Boolean = false
                var oldString : String = ""

                override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                        //doNothing
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                    if (isEmail(s.toString())){
                        //doNothing
                    }else{
                        val str = replaceChars(s.toString())
                        var cpfWithMask = ""

                        if (count == 0)//is deleting
                            isUpdating = true

                        if (isUpdating){
                            oldString = str
                            isUpdating = false
                            return
                        }

                        var i = 0
                        for (m : Char in CPF_FORMAT.toCharArray()){
                            if (m != '#' && str.length > oldString.length){
                                cpfWithMask += m
                                continue
                            }
                            try {
                                cpfWithMask += str.get(i)
                            }catch (e : Exception){
                                break
                            }
                            i++
                        }
                        isUpdating = true
                        editText.setText(cpfWithMask)
                        editText.setSelection(cpfWithMask.length)
                    }
                }

                override fun afterTextChanged(editable: Editable) {
                    //doNothing
                }
            }
            editText.addTextChangedListener(textWatcher)
            return textWatcher
        }

        fun isEmail(password: String): Boolean {
            val digit: Pattern = Pattern.compile("[a-zA-Z]+")
            val hasLetter: Matcher = digit.matcher(password)
            return hasLetter.find()
        }
    }
}