package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Composable
fun MovieCard(
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.size(122.dp, 179.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 10.dp
    ) {
        AsyncImage(
            model = imageUrl,
            placeholder = painterResource(id = R.drawable.ic_broken_image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier.padding(5.dp)
        ) {
            FavoriteButton(
                backgroundColor = colorResource(id = R.color.favorite_button_background)
            )
        }
    }
}

@Preview
@Composable
private fun MoveCardPreview() {
    MovieCard(
        imageUrl =
        "https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg"
    )
}