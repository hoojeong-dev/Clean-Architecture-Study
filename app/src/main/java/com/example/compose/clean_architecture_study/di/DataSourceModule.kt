package com.example.compose.clean_architecture_study.di

import com.example.compose.clean_architecture_study.data.source.GithubRemoteSource
import com.example.compose.clean_architecture_study.data.source.GithubRemoteSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindGithubRemoteSource(source: GithubRemoteSourceImpl): GithubRemoteSource
}