package ninja.ciox.accessibility.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ninja.ciox.accessibility.repository.DefaultPostsRepository
import ninja.ciox.accessibility.repository.PostsRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun providesPostsRepository(defaultPostsRepository: DefaultPostsRepository): PostsRepository
}