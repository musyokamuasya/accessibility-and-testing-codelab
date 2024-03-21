package ninja.ciox.accessibility.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.filterToOne
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import org.junit.Before

import org.robolectric.shadows.ShadowLog


interface ComposeTestUtils {

    abstract val composeTestRule: ComposeContentTestRule

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out
    }


    fun printComposeUiTreeToLog(testTag: String? = null) {
        if (testTag.isNullOrEmpty()) {
            composeTestRule.onRoot().printToLog("TAG")
        } else {
            composeTestRule.onNodeWithTag(testTag).printToLog("TAG")
        }
    }

    fun onNodeWithTestTag(tag: String, parentTestTag: String? = null) =
        if (parentTestTag != null) {
            composeTestRule.onAllNodesWithTag(tag)
                .filterToOne(hasParent(hasTestTag(parentTestTag)))
                .assertIsDisplayed()
        } else {
            composeTestRule.onNodeWithTag(tag)
                .assertIsDisplayed()
        }

    fun retrieveTextFromNodeWithTestTag(tag: String, parentTestTag: String? = null): String =
        (onNodeWithTestTag(tag, parentTestTag)
            .fetchSemanticsNode().config
            .first { it.key.name == "Text" }
            .value as List<*>).first().toString()
}