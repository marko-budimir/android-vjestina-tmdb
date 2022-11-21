package agency.five.codebase.android.movieapp.ui.home

import agency.five.codebase.android.movieapp.R
import agency.five.codebase.android.movieapp.mock.MoviesMock
import agency.five.codebase.android.movieapp.model.MovieCategory
import agency.five.codebase.android.movieapp.model.MovieCategory.*
import agency.five.codebase.android.movieapp.ui.component.MovieCard
import agency.five.codebase.android.movieapp.ui.component.MovieCardViewState
import agency.five.codebase.android.movieapp.ui.component.MovieCategoryLabel
import agency.five.codebase.android.movieapp.ui.home.mapper.HomeScreenMapper
import agency.five.codebase.android.movieapp.ui.home.mapper.HomeScreenMapperImpl
import agency.five.codebase.android.movieapp.ui.theme.MovieAppTheme
import agency.five.codebase.android.movieapp.ui.theme.spacing
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

private val homeScreenMapper: HomeScreenMapper = HomeScreenMapperImpl()
val movies = MoviesMock.getMoviesList()

val popular = listOf(
    POPULAR_STREAMING,
    POPULAR_ON_TV,
    POPULAR_FOR_RENT,
    POPULAR_IN_THEATRES
)
val nowPlaying = listOf(
    NOW_PLAYING_MOVIES,
    NOW_PLAYING_TV
)
val upcoming = listOf(
    UPCOMING_TODAY,
    UPCOMING_THIS_WEEK
)

var popularCategoryViewState = homeScreenMapper.toHomeMovieCategoryViewState(
    movieCategories = popular,
    selectedMovieCategory = POPULAR_STREAMING,
    movies = movies
)
var nowPlayingCategoryViewState = homeScreenMapper.toHomeMovieCategoryViewState(
    movieCategories = nowPlaying,
    selectedMovieCategory = NOW_PLAYING_MOVIES,
    movies = movies
)
var upcomingCategoryViewState = homeScreenMapper.toHomeMovieCategoryViewState(
    movieCategories = upcoming,
    selectedMovieCategory = UPCOMING_TODAY,
    movies = movies
)

@Composable
fun HomeRoute(
    onNavigateToMovieDetails: (Int) -> Unit
) {
    HomeScreen(
        onCategoryClick = onNavigateToMovieDetails
    )
}

@Composable
fun HomeScreen(
    onCategoryClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        item {
            Section(
                viewState = popularCategoryViewState,
                header = stringResource(id = R.string.what_is_popular),
                onCategoryClick = onCategoryClick
            )
        }
        item {
            Section(
                viewState = nowPlayingCategoryViewState,
                header = stringResource(id = R.string.now_playing),
                onCategoryClick = onCategoryClick
            )
        }
        item {
            Section(
                viewState = upcomingCategoryViewState,
                header = stringResource(id = R.string.upcoming),
                onCategoryClick = onCategoryClick
            )
        }

    }

}

@Composable
fun Section(
    viewState: HomeMovieCategoryViewState,
    header: String,
    onCategoryClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = header,
            style = MaterialTheme.typography.h3,
            color = colorResource(id = R.color.black_text),
            modifier = Modifier.padding(
                top = MaterialTheme.spacing.medium,
                start = MaterialTheme.spacing.medium
            )
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium),
            contentPadding = PaddingValues(MaterialTheme.spacing.medium)
        ) {
            items(
                items = viewState.movieCategories,
                key = { homeMovieViewState ->
                    homeMovieViewState.itemId
                }
            ) { movieCategoryLabel ->
                MovieCategoryLabel(
                    labelViewState = movieCategoryLabel,
                    onItemClick = { /*TODO*/ }
                )
            }
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small),
            contentPadding = PaddingValues(horizontal = MaterialTheme.spacing.medium),
            modifier = Modifier.padding(bottom = MaterialTheme.spacing.medium)
        ) {
            items(
                items = popularCategoryViewState.movies,
                key = { homeMovieViewState ->
                    homeMovieViewState.id
                }
            ) { homeMovieViewState ->
                MovieCard(
                    movieCardViewState = MovieCardViewState(
                        imageUrl = homeMovieViewState.imageUrl,
                        isFavorite = homeMovieViewState.isFavorite
                    ),
                    onCardClick = { onCategoryClick(homeMovieViewState.id) },
                    onLikeButtonClick = { /*TODO*/ },
                    modifier = Modifier
                        .height(dimensionResource(id = R.dimen.movie_card_height))
                        .widthIn(max = dimensionResource(id = R.dimen.movie_card_width))
                )
            }
        }
    }
}

fun selectCategory(itemId: Int) {
    when (itemId) {
        0, 1, 2, 3 -> {
            popularCategoryViewState =
                homeScreenMapper.toHomeMovieCategoryViewState(
                    popular,
                    MovieCategory.values()[itemId],
                    movies
                )
        }
        4, 5 -> {
            nowPlayingCategoryViewState =
                homeScreenMapper.toHomeMovieCategoryViewState(
                    nowPlaying,
                    MovieCategory.values()[itemId],
                    movies
                )
        }
        else -> {
            upcomingCategoryViewState =
                homeScreenMapper.toHomeMovieCategoryViewState(
                    upcoming,
                    MovieCategory.values()[itemId],
                    movies
                )
        }
    }

}

@Preview
@Composable
fun HomeScreenPreview() {
    MovieAppTheme {
        HomeScreen({ itemId -> selectCategory(itemId) })
    }
}