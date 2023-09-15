package com.example.compose.clean_architecture_study.data.source

import com.example.compose.clean_architecture_study.data.dao.GithubRepoDao


interface GithubRemoteSource {
    suspend fun getRepos(owner: String): List<GithubRepoDao>
}