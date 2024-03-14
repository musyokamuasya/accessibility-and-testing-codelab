package ninja.ciox.accessibility.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ninja.ciox.accessibility.datasource.remote.JsonPlaceholderApiService
import ninja.ciox.accessibility.datasource.remote.dto.asDomainPost
import ninja.ciox.accessibility.domain.model.Post
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

interface PostsRepository {
    suspend fun getAllPosts(): Flow<Result<List<Post>>>
}

class DefaultPostsRepository @Inject constructor(private val apiService: JsonPlaceholderApiService) :
    PostsRepository {
    override suspend fun getAllPosts(): Flow<Result<List<Post>>> = flow {
        try {
            val posts = apiService.getAllPosts()
            emit(Result.success(posts.map { postDto -> postDto.asDomainPost() }))
        } catch (e: Exception) {
            when (e) {
                is HttpException -> {
                    Log.d("Posts Repository", e.message ?: "")
                }

                is IOException -> {
                    Log.d("Posts Repository", e.message ?: "")
                }

                else -> {
                    Log.d("Posts Repository", e.message ?: "")
                }
            }
        }
    }
}