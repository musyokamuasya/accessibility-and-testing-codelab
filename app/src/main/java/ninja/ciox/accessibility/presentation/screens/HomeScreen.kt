package ninja.ciox.accessibility.presentation.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ninja.ciox.accessibility.presentation.models.UiPost
import ninja.ciox.accessibility.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier, homeViewModel: HomeViewModel = hiltViewModel()) {
    val postsState by homeViewModel.postsState.collectAsState()

    LazyColumn(modifier = modifier.testTag("lazy column")) {

        items(postsState.posts) { uiPost ->
            Posts(modifier = modifier, uiPost = uiPost)
        }
    }
}

@Composable
fun Posts(modifier: Modifier = Modifier, uiPost: UiPost) {
    var isExpanded by remember { mutableStateOf(false) }
    OutlinedCard(onClick = { isExpanded = !isExpanded }, modifier = modifier.padding(8.dp).fillMaxWidth()) {
        Text(
            text = uiPost.title,
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier.padding(horizontal = 16.dp, vertical = 4.dp).testTag("title")
        )
        Text(
            text = uiPost.body,
            style = MaterialTheme.typography.bodyMedium,
            modifier = modifier.padding(horizontal = 16.dp, vertical = 4.dp).testTag("desc"),
            maxLines = if (isExpanded) Int.MAX_VALUE else 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}