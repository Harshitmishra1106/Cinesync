package com.example.cinesync.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.cinesync.shimmerEffect.ShimmerDetailPlaceholder
import com.example.cinesync.viewModels.DetailsViewModel

@Composable
fun DetailScreen(id: Int?, viewModel: DetailsViewModel = viewModel()) {
        val details = viewModel.details
        val isLoading = viewModel.isLoading

        LaunchedEffect(id) {
            viewModel.fetchDetails(id!!)
        }

        Box(modifier = Modifier.fillMaxSize()) {
            AnimatedVisibility(
                visible = isLoading,
                enter = fadeIn(tween(400)),
                exit = fadeOut(tween(300))
            ){
                ShimmerDetailPlaceholder()
            }
            AnimatedVisibility(
                visible = !isLoading && details != null,
                enter = fadeIn(tween(400)),
                exit = fadeOut(tween(300))
            )  {
                details?.let { title ->
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                            .statusBarsPadding()
                    ) {
                        item {
                            AsyncImage(
                                model = title.poster ?: "",
                                contentDescription = title.title,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(400.dp)
                                    .clip(RoundedCornerShape(16.dp)),
                                contentScale = ContentScale.Crop
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            Text(
                                text = title.title,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "Released: ${title.release_date ?: "N/A"}",
                                fontSize = 14.sp,
                                color = Color.Gray
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = title.plot_overview ?: "No overview available.",
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }
}
