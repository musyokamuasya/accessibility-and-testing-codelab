package ninja.ciox.accessibility.presentation.models

data class PostsUiState(
    val posts: List<UiPost> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
)