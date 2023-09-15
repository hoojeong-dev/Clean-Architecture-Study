package com.example.compose.clean_architecture_study.domain


interface GithubRepository {
    suspend fun getRepos(owner: String): List<GithubRepo>
}