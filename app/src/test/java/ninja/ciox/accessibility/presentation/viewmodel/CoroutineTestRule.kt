package ninja.ciox.accessibility.presentation.viewmodel

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExecutorCoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class CoroutineTestRule @OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
@ObsoleteCoroutinesApi constructor(
    private val testDispatcher: ExecutorCoroutineDispatcher = newSingleThreadContext("UI thread"),
) : TestWatcher() {
    @OptIn(ExperimentalCoroutinesApi::class)
    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(testDispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun finished(description: Description?) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}