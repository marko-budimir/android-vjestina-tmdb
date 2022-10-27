package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private var isFavorite = false

@Composable
fun FavoriteButton(
    backgroundColor: Color
) {
    Image(
        painter = painterResource(id = if (isFavorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite),
        contentDescription = null,
        modifier = Modifier
            .clickable {
                isFavorite = isFavorite.not()
            }
            .size(32.dp)
            .background(backgroundColor, CircleShape)
            .padding(8.dp)
    )
}

@Preview
@Composable
private fun FavoriteButtonPreview() {
    FavoriteButton(colorResource(id = R.color.favorite_button_background))
}