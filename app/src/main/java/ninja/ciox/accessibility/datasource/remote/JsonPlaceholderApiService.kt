package ninja.ciox.accessibility.datasource.remote

import ninja.ciox.accessibility.datasource.remote.dto.PostDto
import retrofit2.http.GET

interface JsonPlaceholderApiService {
    @GET("posts")
    suspend fun getAllPosts(): List<PostDto>
}