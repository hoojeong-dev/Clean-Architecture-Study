package com.example.compose.clean_architecture_study.domain

import com.example.compose.clean_architecture_study.domain.interfaces.GithubRepo
import com.example.compose.clean_architecture_study.domain.interfaces.GithubRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


class GetGithubUseCase(private val githubRepository: GithubRepository) {

    operator fun invoke(owner: String, scope: CoroutineScope, onResult: (List<GithubRepo>) -> Unit) {

        scope.launch {

            val deferred = async(Dispatchers.IO) {
                githubRepository.getRepos(owner)
            }

            onResult(deferred.await())
        }
    }
}