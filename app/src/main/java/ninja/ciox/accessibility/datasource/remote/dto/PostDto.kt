package ninja.ciox.accessibility.datasource.remote.dto


import com.squareup.moshi.Json
import ninja.ciox.accessibility.domain.model.Post

data class PostDto(

    @Json(name = "body")
    val body: String,

    @Json(name = "id")
    val id: Int,

    @Json(name = "title")
    val title: String,

    @Json(name = "userId")
    val userId: Int
)

fun PostDto.asDomainPost(): Post {
    return Post(
        body = body,
        id = id,
        title = title,
        userId = userId
    )
}

