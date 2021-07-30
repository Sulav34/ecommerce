package com.example.ecommercesiteforonlineshopping

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import com.example.ecommercesiteforonlineshopping.ui.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@LargeTest
@RunWith(JUnit4::class)
class TestLogin {
    @get:Rule
    val testRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun LoginActivityTest(){
        onView(withId(R.id.etLoginEmail))
            .perform(typeText("sulavstha@gmail.com"))

        onView(withId(R.id.etLoginPassword))
            .perform(typeText("123456"))

        closeSoftKeyboard()

        onView(withId(R.id.btnLogin))
            .perform(click())

        Thread.sleep(2000)

        onView(withId(R.id.recyclerView))
            .check(matches(withText("Products")))

    }
}