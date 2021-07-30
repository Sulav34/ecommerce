package com.example.ecommercesiteforonlineshopping

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule

import androidx.test.filters.LargeTest
import com.example.ecommercesiteforonlineshopping.ui.RegistrationActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@LargeTest
@RunWith(JUnit4::class)
class TestRegister {
    @get:Rule
    val testRule = ActivityScenarioRule(RegistrationActivity::class.java)


    @Test
    fun RegistrationActivity() {
        Espresso.onView(withId(R.id.etfname))
            .perform(typeText("karun"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(withId(R.id.etLname))
            .perform(typeText("Kumar"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(withId(R.id.etEmail))
            .perform(typeText("karun@gmail.com"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(withId(R.id.etPassword))
            .perform(typeText("karun123"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(withId(R.id.etCnfpassword))
            .perform(typeText("karun123"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(withId(R.id.etAddress))
            .perform(typeText("Nepal"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(withId(R.id.etContact))
            .perform(typeText("987678987"))
        Espresso.closeSoftKeyboard()






        Espresso.onView(ViewMatchers.withId(R.id.btnregister))
            .perform(ViewActions.click())

        Thread.sleep(10000)

//        Espresso.onView(ViewMatchers.withId(R.id.tvSignup))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }
}