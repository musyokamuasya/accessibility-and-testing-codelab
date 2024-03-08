package ninja.ciox.accessibility.presentation.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class SignUpScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup(){
        composeTestRule.setContent {
            SignUpScreen()
        }
    }

    @Test
    fun onInitialDisplay_welcomeMessage_isDisplayed(){
        composeTestRule.onNodeWithText("Welcome text message").isDisplayed()
    }

    @Test
    fun onSignUpButton_whenClicked_clearNameText(){
        composeTestRule.onNode(hasTestTag("Sign me up")).assertIsDisplayed()
    }

    @Test
    fun onInitialDisplay_columnIsCreated_isDisplayed(){
        composeTestRule.onNode(hasTestTag("column")).isDisplayed()
    }
}