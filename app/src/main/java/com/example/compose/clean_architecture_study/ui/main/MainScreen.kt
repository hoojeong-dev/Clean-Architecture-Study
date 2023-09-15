package com.example.compose.clean_architecture_study.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.clean_architecture_study.ui.main.component.RepositoryList


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    moveToDetail: (String) -> Unit
) {

    val viewModel: MainViewModel = hiltViewModel()
    val focusManager = LocalFocusManager.current
    val field = remember { mutableStateOf(TextFieldValue("")) }

    Column {

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp),
            value = field.value,
            onValueChange = { field.value = it },
            placeholder = {
                Text(
                    text = "Github Name",
                    color = Color(0xFFBCBCBC)
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Name"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {

                    // hide keyboard
                    focusManager.clearFocus()

                    // get repositories
                    viewModel.getGithubRepositories(field.value.text)
                }
            ),
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedLabelColor = Color(0xFF2D2D2D),
                unfocusedLabelColor = Color(0xFF2D2D2D),
                focusedLeadingIconColor = Color(0xFFBCBCBC),
                unfocusedLeadingIconColor = Color(0xFFBCBCBC),
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
            )
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
            color = Color(0xFFF0F0F0)
        )

        RepositoryList(
            viewModel = viewModel,
            onItemClicked = { url -> moveToDetail(url) }
        )
    }
}