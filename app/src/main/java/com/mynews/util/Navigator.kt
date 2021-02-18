package com.mynews.util

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.mynews.R
import com.mynews.di.compose.ViewModelFragment

class Navigator (private val supportFragmentManager: FragmentManager){

    private inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
        val fragmentTransaction = beginTransaction()
        fragmentTransaction.func()
        fragmentTransaction.commit()
    }

    fun addFragment(fragment: ViewModelFragment){
        supportFragmentManager.inTransaction {
            addToBackStack("")
            add(R.id.nav_host_fragment, fragment)
        }
    }

    fun replaceFragment(fragment: ViewModelFragment){
        supportFragmentManager.inTransaction {
            addToBackStack("")
            replace(R.id.nav_host_fragment, fragment)
        }
    }

}