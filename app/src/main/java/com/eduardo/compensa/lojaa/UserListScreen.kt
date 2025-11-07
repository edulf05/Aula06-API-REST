package com.eduardo.compensa.lojaa

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun UserListScreen(users: List<User>) {
    LazyColumn {
        items(users) {
            user -> Text(text = "${user.name}, ${user.email}, ${user.age}")
        }
    }
}