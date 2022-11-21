package agency.five.codebase.android.movieapp.ui.moviedetails

import agency.five.codebase.android.movieapp.R
import agency.five.codebase.android.movieapp.mock.MoviesMock
import agency.five.codebase.android.movieapp.ui.component.*
import agency.five.codebase.android.movieapp.ui.moviedetails.mapper.MovieDetailsMapper
import agency.five.codebase.android.movieapp.ui.moviedetails.mapper.MovieDetailsMapperImpl
import agency.five.codebase.android.movieapp.ui.theme.MovieAppTheme
import agency.five.codebase.android.movieapp.ui.theme.spacing
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage


private val movieDetailsMapper: MovieDetailsMapper = MovieDetailsMapperImpl()

val movieDetailsViewState = movieDetailsMapper.toMovieDetailsViewState(MoviesMock.getMovieDetails())

@Composable
fun MovieDetailsRoute() {
    val viewState by remember { mutableStateOf(movieDetailsViewState) }
    MovieDetailsScreen(
        viewState
    )
}

@Composable
fun MovieDetailsScreen(
    viewState: MovieDetailsViewState,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            MovieDetailsTitle(viewState) { viewState.isFavorite = !viewState.isFavorite }
        }
        item {
            MovieDetailsOverView(
                viewState,
                Modifier.padding(horizontal = MaterialTheme.spacing.medium)
            )
        }
        item {
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
            MovieDetailsTopCast(viewState)
        }
    }
}

@Composable
fun MovieDetailsTitle(
    viewState: MovieDetailsViewState,
    onLikeButtonClick: () -> Unit,
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        val (image, column) = createRefs()
        AsyncImage(
            model = viewState.imageUrl,
            placeholder = painterResource(id = R.drawable.ic_broken_image),
            contentDescription = viewState.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                }
        )

        Column(
            modifier = Modifier
                .padding(MaterialTheme.spacing.medium)
                .constrainAs(column) {
                    bottom.linkTo(image.bottom)
                }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                UserScoreProgressBar(
                    score = movieDetailsViewState.voteAverage,
                    textColor = colorResource(id = R.color.white_text),
                    modifier = Modifier.padding(end = MaterialTheme.spacing.small)
                )
                Text(
                    text = stringResource(id = R.string.movie_details_user_score),
                    style = MaterialTheme.typography.h6,
                    color = colorResource(id = R.color.white_text)
                )
            }

            Text(
                text = movieDetailsViewState.title,
                style = MaterialTheme.typography.h2,
                color = colorResource(id = R.color.white_text),
                modifier = Modifier.padding(
                    top = MaterialTheme.spacing.small,
                    bottom = MaterialTheme.spacing.medium
                )
            )
            FavoriteButton(
                backgroundColor = colorResource(id = R.color.favorite_button_background),
                isFavorite = movieDetailsViewState.isFavorite,
                onClick = onLikeButtonClick
            )
        }

    }
}

@Composable
fun MovieDetailsOverView(
    viewState: MovieDetailsViewState,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.movie_details_overview),
            style = MaterialTheme.typography.h3,
            color = colorResource(id = R.color.black_text),
            modifier = Modifier.padding(top = MaterialTheme.spacing.medium)
        )
        Text(
            text = viewState.overview,
            style = MaterialTheme.typography.body2,
            color = colorResource(id = R.color.black_text),
            modifier = Modifier.padding(top = MaterialTheme.spacing.small)
        )
        Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(
                space = MaterialTheme.spacing.extraLarge
            ),
            userScrollEnabled = false,
            modifier = Modifier
                .height(120.dp)
                .fillMaxWidth()
        ) {
            items(
                items = viewState.crew,
                key = { crewman ->
                    crewman.id
                }
            ) { crewman ->
                CrewItem(
                    crewItemViewState = CrewItemViewState(
                        id = crewman.id,
                        name = crewman.name,
                        job = crewman.job
                    )
                )
            }
        }
    }
}

@Composable
fun MovieDetailsTopCast(
    viewState: MovieDetailsViewState,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.movie_details_top_billed_cast),
            style = MaterialTheme.typography.h3,
            color = colorResource(id = R.color.black_text),
            modifier = Modifier.padding(horizontal = MaterialTheme.spacing.medium)
        )
        LazyRow {
            item {
                Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))
            }
            items(
                items = viewState.cast,
                key = { actor ->
                    actor.id
                }
            ) { actor ->
                ActorCard(
                    actorCardViewState = actor,
                    modifier = Modifier
                        .padding(MaterialTheme.spacing.small)
                        .size(
                            dimensionResource(id = R.dimen.actor_card_width),
                            dimensionResource(id = R.dimen.actor_card_height)
                        )
                )
            }
        }
    }
}

@Preview
@Composable
fun MovieDetailsScreenPreview() {
    MovieAppTheme {
        MovieDetailsScreen(
            movieDetailsViewState,
            modifier = Modifier.fillMaxWidth()
        )
    }
}