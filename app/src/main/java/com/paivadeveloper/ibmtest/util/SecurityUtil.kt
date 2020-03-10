package com.paivadeveloper.ibmtest.util

import android.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class SecurityUtil {

    companion object{
        private val ALGORITHM = "Blowfish"
        private val MODE = "Blowfish/CBC/PKCS5Padding"
        private val IV = "abcdefgh"
        private val KEY = "MyKey"

        fun encrypt(value: String): String? {
            val secretKeySpec = SecretKeySpec(KEY.toByteArray(), ALGORITHM)
            val cipher: Cipher = Cipher.getInstance(MODE)
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, IvParameterSpec(IV.toByteArray()))
            val values: ByteArray = cipher.doFinal(value.toByteArray())
            return Base64.encodeToString(values, Base64.DEFAULT)
        }

        fun decrypt(value: String?): String? {
            val values: ByteArray = Base64.decode(value, Base64.DEFAULT)
            val secretKeySpec = SecretKeySpec(KEY.toByteArray(), ALGORITHM)
            val cipher: Cipher = Cipher.getInstance(MODE)
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, IvParameterSpec(IV.toByteArray()))
            return String(cipher.doFinal(values))
        }
    }
}