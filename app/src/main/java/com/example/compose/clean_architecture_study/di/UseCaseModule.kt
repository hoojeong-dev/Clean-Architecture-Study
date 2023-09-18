package com.example.compose.clean_architecture_study.di

import com.example.compose.clean_architecture_study.domain.GetGithubUseCase
import com.example.compose.clean_architecture_study.domain.interfaces.GithubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun providesGetGithubReposUseCase(repository: GithubRepository): GetGithubUseCase {
        return GetGithubUseCase(repository)
    }
}