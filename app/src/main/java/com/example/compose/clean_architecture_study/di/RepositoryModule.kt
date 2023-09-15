package com.example.compose.clean_architecture_study.di

import com.example.compose.clean_architecture_study.data.source.GithubRepositoryImpl
import com.example.compose.clean_architecture_study.domain.GithubRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindsGithubRepository(repository: GithubRepositoryImpl): GithubRepository
}