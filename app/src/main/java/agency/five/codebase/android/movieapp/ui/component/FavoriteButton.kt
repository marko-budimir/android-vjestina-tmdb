package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.R
import agency.five.codebase.android.movieapp.ui.theme.spacing
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FavoriteButton(
    backgroundColor: Color,
    isFavorite: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = if (isFavorite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite),
        contentDescription = null,
        modifier = modifier
            .clickable {
                onClick()
            }
            .size(dimensionResource(id = R.dimen.favorite_button_size))
            .background(backgroundColor, CircleShape)
            .padding(MaterialTheme.spacing.small)
    )
}

@Preview
@Composable
private fun FavoriteButtonPreview() {
    var isFavorite by remember { mutableStateOf(true) }
    FavoriteButton(
        backgroundColor = colorResource(id = R.color.favorite_button_background),
        isFavorite = isFavorite,
        onClick = { isFavorite = !isFavorite }
    )
}
