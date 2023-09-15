package com.example.compose.clean_architecture_study.data.service

import com.example.compose.clean_architecture_study.data.dao.GithubRepoDao
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubService {

    @GET("users/{owner}/repos")
    suspend fun getRepos(@Path("owner") owner: String): List<GithubRepoDao>
}