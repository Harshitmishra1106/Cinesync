package com.example.cinesync.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.cinesync.shimmerEffect.ShimmerListPlaceholder
import com.example.cinesync.viewModels.WatchViewModel


@Composable
fun WatchListScreen(viewModel: WatchViewModel = viewModel(), navController: NavController) {
    val titles by remember { derivedStateOf { viewModel.titles } }
    val isLoading by remember { derivedStateOf { viewModel.isLoading } }
    val isMovieSelected by remember { derivedStateOf { viewModel.isMovieSelected } }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .statusBarsPadding()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Switch(
                checked = isMovieSelected,
                onCheckedChange = { viewModel.toggleType() }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(if (isMovieSelected) "Movies" else "TV Shows")
        }

        Spacer(modifier = Modifier.height(16.dp))

            AnimatedVisibility(
                visible = isLoading,
                enter = fadeIn(tween(400)),
                exit = fadeOut(tween(300))
            ) {
                ShimmerListPlaceholder()
            }

        AnimatedVisibility(
            visible = !isLoading,
            enter = fadeIn(tween(400)),
            exit = fadeOut(tween(300))
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .statusBarsPadding(),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(titles) { item ->
                    MovieCard(item = item){
                        navController.navigate("details/${item.id}")
                    }
                }
            }

        }
    }
}