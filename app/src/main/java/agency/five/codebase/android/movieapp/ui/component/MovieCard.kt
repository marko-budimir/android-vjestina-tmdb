package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.R
import agency.five.codebase.android.movieapp.mock.MoviesMock
import agency.five.codebase.android.movieapp.ui.theme.spacing
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

data class MovieCardViewState(
    val imageUrl: String,
    val isFavorite: Boolean
)

@Composable
fun MovieCard(
    movieCardViewState: MovieCardViewState,
    onCardClick: () -> Unit,
    onLikeButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.clickable { onCardClick() },
        shape = MaterialTheme.shapes.medium,
        elevation = dimensionResource(id = R.dimen.movie_card_elevation)
    ) {
        AsyncImage(
            model = movieCardViewState.imageUrl,
            placeholder = painterResource(id = R.drawable.ic_broken_image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier.padding(MaterialTheme.spacing.extraSmall)
        ) {
            FavoriteButton(
                backgroundColor = colorResource(id = R.color.favorite_button_background),
                isFavorite = movieCardViewState.isFavorite,
                onClick = onLikeButtonClick
            )
        }
    }
}

@Preview
@Composable
private fun MoveCardPreview() {
    var isFavorite by remember { mutableStateOf(false) }
    val mockMovie = MoviesMock.getMoviesList().last()
    MovieCard(
        movieCardViewState = MovieCardViewState(
            imageUrl = mockMovie.imageUrl.orEmpty(),
            isFavorite = isFavorite
        ),
        onCardClick = {},
        onLikeButtonClick = { isFavorite = !isFavorite},
        modifier = Modifier.size(
            dimensionResource(id = R.dimen.movie_card_width),
            dimensionResource(id = R.dimen.movie_card_height)
        )
    )
}