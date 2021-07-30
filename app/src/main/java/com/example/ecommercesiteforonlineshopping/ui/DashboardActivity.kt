package com.example.ecommercesiteforonlineshopping.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.ecommercesiteforonlineshopping.R
import com.example.ecommercesiteforonlineshopping.fragments.*

import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        bottomNav = findViewById(R.id.bottomNav)

        currentFragment(HomeFragment())
        
        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> currentFragment(HomeFragment())
                R.id.add -> currentFragment(CartFragment())
                R.id.about -> currentFragment(AboutFragment())
                R.id.profile -> currentFragment(ProfileFragment())
                R.id.categories -> currentFragment(CategoriesFragment())
            }
            true
        }
    }

    private fun currentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            addToBackStack(null)
            commit()
        }
    }
}