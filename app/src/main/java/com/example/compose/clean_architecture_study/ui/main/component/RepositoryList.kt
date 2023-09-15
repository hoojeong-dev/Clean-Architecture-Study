package com.example.compose.clean_architecture_study.ui.main.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose.clean_architecture_study.ui.main.MainViewModel


@Composable
fun RepositoryList(
    viewModel: MainViewModel,
    onItemClicked: (String) -> Unit
) {

    val list = viewModel.githubRepositories.observeAsState()

    LazyColumn(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(bottom = 10.dp)
    ) {

        list.value?.let { list ->

            items(list) { item ->
                RepositoryItem(
                    item = item,
                    onItemClicked = { onItemClicked(item.url) }
                )
            }
        }
    }
}