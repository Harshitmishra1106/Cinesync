package com.example.cinesync

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.ShimmerBounds
import com.valentinilk.shimmer.rememberShimmer
import com.valentinilk.shimmer.shimmer

@Composable
fun ShimmerListPlaceholder() {
    val shimmer = rememberShimmer(shimmerBounds = ShimmerBounds.Window)
    Column {
        repeat(5) {
            Box(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
                    .height(180.dp)
                    .shimmer(shimmer)
                    .background(Color.Gray.copy(alpha = 0.3f), RoundedCornerShape(12.dp))
            )
        }
    }
}
