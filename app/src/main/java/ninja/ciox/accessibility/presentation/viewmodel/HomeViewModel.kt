package ninja.ciox.accessibility.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ninja.ciox.accessibility.presentation.models.PostsUiState
import ninja.ciox.accessibility.presentation.models.asUiPost
import ninja.ciox.accessibility.repository.PostsRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: PostsRepository) : ViewModel() {
    private val _postsState = MutableStateFlow(PostsUiState())
    val postsState = _postsState.asStateFlow()

    init {
        getAllPosts()
    }

    fun getAllPosts() {
        viewModelScope.launch {
            repository.getAllPosts().collectLatest { postResult ->
                postResult.onSuccess { posts ->
                    _postsState.update { postUiState ->
                        postUiState.copy(posts = posts.map { post -> post.asUiPost() })
                    }
                }.onFailure { error ->
                    _postsState.update { postUiState ->
                        postUiState.copy(error = error.message)
                    }
                }
            }
        }
    }

    fun addTwoNumbers(a: Int, b: Int): Int {
        return a + b
    }
}