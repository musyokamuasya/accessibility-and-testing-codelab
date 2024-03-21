package ninja.ciox.accessibility.presentation.viewmodel

import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ObsoleteCoroutinesApi
import ninja.ciox.accessibility.repository.PostsRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class HomeViewModelTest {
    @OptIn(ObsoleteCoroutinesApi::class)
    @get:Rule
    var coroutineTestRule = CoroutineTestRule()

    @MockK
    lateinit var postsRepository: PostsRepository

    lateinit var postsViewModel: HomeViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        postsViewModel = HomeViewModel(postsRepository)
    }

    @Test
    fun `addTwoNumbers in repository returns correct sum`() {
        val result = postsViewModel.addTwoNumbers(1, 2)

        assertEquals(3, result)
    }

    @Test
    fun `get all posts returns success`(){

    }
}