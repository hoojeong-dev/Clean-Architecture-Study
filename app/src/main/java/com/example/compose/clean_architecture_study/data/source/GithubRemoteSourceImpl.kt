package com.example.compose.clean_architecture_study.data.source

import com.example.compose.clean_architecture_study.data.dao.GithubRepoDao
import com.example.compose.clean_architecture_study.data.service.GithubService
import com.example.compose.clean_architecture_study.domain.interfaces.GithubRemoteSource
import javax.inject.Inject


class GithubRemoteSourceImpl @Inject constructor(
    private val githubService: GithubService
): GithubRemoteSource {

    override suspend fun getRepos(owner: String): List<GithubRepoDao> {
        return githubService.getRepos(owner)
    }
}