package com.example.compose.clean_architecture_study.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose.clean_architecture_study.domain.GetGithubUseCase
import com.example.compose.clean_architecture_study.domain.GithubRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val githubUseCase: GetGithubUseCase): ViewModel() {

    private val _githubRepositories = MutableLiveData<List<GithubRepo>>()
    val githubRepositories: LiveData<List<GithubRepo>> = _githubRepositories

    fun getGithubRepositories(owner: String) {
        githubUseCase(owner, viewModelScope) {
            _githubRepositories.value = it
        }
    }
}