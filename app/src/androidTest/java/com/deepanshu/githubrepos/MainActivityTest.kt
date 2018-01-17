package com.deepanshu.githubrepos


import android.support.test.espresso.action.ViewActions
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4

import com.deepanshu.githubrepos.ui.main.MainActivity

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.closeSoftKeyboard
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.v7.widget.RecyclerView

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule @JvmField
    val mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testEditTextAndButtonClick() {
        onView(withId(R.id.edt_username)).perform(ViewActions.typeText("DeepanshuHarbola"), closeSoftKeyboard())
        onView(withId(R.id.btn_search)).perform(click())
    }

    @Test
    fun testRecyclerViewDisplayed() {
        onView(withId(R.id.rv_repos)).check(matches(isDisplayed()))
    }

    @Test
    fun testScrollAndClickRecycleView() {
        onView(withId(R.id.rv_repos))
                .perform(scrollToPosition<RecyclerView.ViewHolder>(5), click())
                .perform(scrollToPosition<RecyclerView.ViewHolder>(0), click())
                .perform(scrollToPosition<RecyclerView.ViewHolder>(10), click())
    }
}
