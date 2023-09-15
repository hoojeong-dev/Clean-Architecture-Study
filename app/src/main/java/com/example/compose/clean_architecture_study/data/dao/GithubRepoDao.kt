package com.example.compose.clean_architecture_study.data.dao

import com.example.compose.clean_architecture_study.domain.GithubRepo
import com.google.gson.annotations.SerializedName


data class GithubRepoDao (

    @SerializedName("name")
    private val _name: String,

    @SerializedName("id")
    private val _id: String,

    @SerializedName("created_at")
    private val _date: String,

    @SerializedName("html_url")
    private val _url: String

): GithubRepo {

    override val name: String
        get() = _name

    override val url: String
        get() = _url
}