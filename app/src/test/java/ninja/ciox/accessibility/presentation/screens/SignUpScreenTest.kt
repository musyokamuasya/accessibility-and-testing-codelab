package ninja.ciox.accessibility.presentation.screens

import androidx.compose.ui.test.assertIsDisplayed
import org.junit.Rule
import org.junit.runner.RunWith
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import ninja.ciox.accessibility.MainActivity
import org.junit.Before
import org.junit.Test
import org.robolectric.shadows.ShadowLog
import kotlin.jvm.Throws


@RunWith(AndroidJUnit4::class)
class SignUpScreenTest{
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setup(){
        ShadowLog.stream = System.out
    }

    @Test
    fun `on sign up button clicked navigates to home`(){
        ActivityScenario.launch(MainActivity::class.java).use {activityScenario ->
            activityScenario.onActivity {activity ->
                composeTestRule.onNodeWithTag("signup button").performClick()
                activity.recreate()
                composeTestRule.onNodeWithTag("lazy column").assertIsDisplayed()
            }
        }
    }

    @Test
    fun `sign up screen is displayed on activity recreate`(){
        ActivityScenario.launch(MainActivity::class.java).use {activityScenario ->
            activityScenario.onActivity {activity ->
                composeTestRule.onNodeWithTag("signup button").assertIsDisplayed()
                activity.recreate()
                composeTestRule.onNodeWithTag("signup button").assertIsDisplayed()
            }
        }
    }
}