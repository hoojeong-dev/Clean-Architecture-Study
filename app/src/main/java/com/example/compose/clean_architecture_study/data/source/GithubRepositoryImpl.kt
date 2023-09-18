package com.example.compose.clean_architecture_study.data.source

import com.example.compose.clean_architecture_study.domain.interfaces.GithubRemoteSource
import com.example.compose.clean_architecture_study.domain.interfaces.GithubRepo
import com.example.compose.clean_architecture_study.domain.interfaces.GithubRepository
import javax.inject.Inject


class GithubRepositoryImpl @Inject constructor(
    private val githubRemoteSource: GithubRemoteSource
): GithubRepository {

    override suspend fun getRepos(owner: String): List<GithubRepo> {
        return githubRemoteSource.getRepos(owner)
    }
}