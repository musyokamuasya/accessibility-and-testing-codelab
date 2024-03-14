package ninja.ciox.accessibility.presentation.models

import ninja.ciox.accessibility.domain.model.Post

data class UiPost(

    val body: String,

    val id: Int,

    val title: String,

    val userId: Int,
)

fun Post.asUiPost(): UiPost {
    return UiPost(
        body = body,
        id = id,
        title = title,
        userId = userId
    )
}