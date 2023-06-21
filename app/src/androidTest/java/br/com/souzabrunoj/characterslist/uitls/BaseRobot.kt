package br.com.souzabrunoj.characterslist.uitls

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.CoreMatchers.not

open class BaseRobot {
    fun assertText(@IdRes viewId: Int, text: String) {
        onView(withId(viewId)).check(matches(withText(text)))
    }

    fun checkIfViewIsNotDisplayed(@IdRes viewId: Int){
        onView(withId(viewId)).check(matches(not(isDisplayed())))
    }
}