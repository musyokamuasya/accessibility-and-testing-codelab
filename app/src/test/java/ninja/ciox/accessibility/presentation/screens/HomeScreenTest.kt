package ninja.ciox.accessibility.presentation.screens

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ActivityScenario
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import ninja.ciox.accessibility.MainActivity
import ninja.ciox.accessibility.domain.model.Post
import ninja.ciox.accessibility.presentation.models.asUiPost
import ninja.ciox.accessibility.presentation.viewmodel.HomeViewModel
import ninja.ciox.accessibility.repository.PostsRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog


@RunWith(RobolectricTestRunner::class)
class HomeScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out
    }

    @Test
    fun `on configuration change sign up is displayed`() {
        ActivityScenario.launch(MainActivity::class.java).use { activityScenario ->
            activityScenario.onActivity { activity ->
                composeTestRule.onNodeWithTag("column").assertIsDisplayed()
                activity.recreate()
                composeTestRule.onNodeWithTag("column").assertIsDisplayed()
            }
        }
    }

    @Test
    fun `on login button clicked homescreen is displayed`() {
        ActivityScenario.launch(MainActivity::class.java).use { activityScenario ->
            activityScenario.onActivity { activity ->
                composeTestRule.onNodeWithTag("signup button").performClick()
                composeTestRule.onNodeWithTag("lazy column").assertIsDisplayed()

            }
        }
    }

    @Test
    fun `should show posts list and details`() {
        val postsRepository = mockk<PostsRepository>()
        coEvery { postsRepository.getAllPosts() } returns flow {
            flowOf(listOf(Post(id = 1, title = "Post 1", body = "Post 1 body", userId = 1).asUiPost()))
        }

        composeTestRule.setContent {
            HomeScreen(homeViewModel = HomeViewModel(postsRepository))
        }

        with(composeTestRule) {
            onNodeWithTag("lazy column").assertExists()
            onNodeWithTag("desc").assertExists()
        }
    }
}