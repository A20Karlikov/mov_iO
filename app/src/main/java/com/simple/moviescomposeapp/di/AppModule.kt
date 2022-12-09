package com.simple.moviescomposeapp.di

import com.simple.moviescomposeapp.data.repository_impl.MoviesRepositoryImpl
import com.simple.moviescomposeapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideMoviesRepository(repository: MoviesRepositoryImpl): MovieRepository = repository

}