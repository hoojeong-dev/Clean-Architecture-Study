package com.example.compose.clean_architecture_study.data.source

import com.example.compose.clean_architecture_study.domain.GithubRepo
import com.example.compose.clean_architecture_study.domain.GithubRepository
import javax.inject.Inject
import javax.inject.Singleton


class GithubRepositoryImpl @Inject constructor(
    private val githubRemoteSource: GithubRemoteSource
): GithubRepository {

    override suspend fun getRepos(owner: String): List<GithubRepo> {
        return githubRemoteSource.getRepos(owner)
    }
}