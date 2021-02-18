package com.mynews.util

import java.util.regex.Pattern

/**
 * Created by Akshay Raj on 06-02-2017.
 * akshay@snowcorp.org
 * www.snowcorp.org
 */
class Functions {

    companion object {
        /**
         * Email Address Validation
         */
        fun isValidEmailAddress(email: String?): Boolean {
            val ePattern =
                "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$"
            val p = Pattern.compile(ePattern)
            val m = p.matcher(email)
            return m.matches()
        }
    }
}