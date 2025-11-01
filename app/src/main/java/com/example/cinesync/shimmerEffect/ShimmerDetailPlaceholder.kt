package com.example.cinesync.shimmerEffect

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer

@Composable
fun ShimmerDetailPlaceholder() {
    val shimmer = rememberShimmer(shimmerBounds = ShimmerBounds.View)
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(300.dp, 400.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.Gray)
                .shimmer(shimmer)
        )
        Spacer(Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .height(24.dp)
                .width(200.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Gray)
                .shimmer(shimmer)
        )
    }
}
