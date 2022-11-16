package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.R
import agency.five.codebase.android.movieapp.ui.theme.Typography
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun UserScoreProgressBar(
    score: Double,
    modifier: Modifier = Modifier,
    radius: Dp = 20.dp

) {
    val trueScore = if (score > 10) 10 else if (score < 0) 0 else score
    val colorPrimary = colorResource(id = R.color.progress_bar_primary)
    val colorSecondary = colorResource(id = R.color.progress_bar_secondary)
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.size(radius * 2.1f)
    ) {
        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawCircle(
                color = colorSecondary,
                style = Stroke(2.dp.toPx())
            )
            drawArc(
                color = colorPrimary,
                -90f,
                36 * trueScore.toFloat(),
                useCenter = false,
                style = Stroke((radius / 10).toPx(), cap = StrokeCap.Round)
            )

        }
        Text(
            text = trueScore.toString(),
            style = Typography.h5
        )
    }

}

@Preview
@Composable
fun UserScoreProgressBarPreview() {
    UserScoreProgressBar(7.6)
}