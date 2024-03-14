package ninja.ciox.accessibility.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ninja.ciox.accessibility.Constants.BASE_URL
import ninja.ciox.accessibility.datasource.remote.JsonPlaceholderApiService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideEventsApiService(): JsonPlaceholderApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(JsonPlaceholderApiService::class.java)
    }
}