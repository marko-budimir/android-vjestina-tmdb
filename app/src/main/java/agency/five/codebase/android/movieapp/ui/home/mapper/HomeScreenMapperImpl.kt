package agency.five.codebase.android.movieapp.ui.home.mapper

import agency.five.codebase.android.movieapp.R
import agency.five.codebase.android.movieapp.model.Movie
import agency.five.codebase.android.movieapp.model.MovieCategory
import agency.five.codebase.android.movieapp.model.MovieCategory.*
import agency.five.codebase.android.movieapp.ui.component.MovieCategoryLabelTextViewState
import agency.five.codebase.android.movieapp.ui.component.MovieCategoryLabelViewState
import agency.five.codebase.android.movieapp.ui.home.HomeMovieCategoryViewState
import agency.five.codebase.android.movieapp.ui.home.HomeMovieViewState

class HomeScreenMapperImpl : HomeScreenMapper {

    override fun toHomeMovieCategoryViewState(
        movieCategories: List<MovieCategory>,
        selectedMovieCategory: MovieCategory,
        movies: List<Movie>
    ): HomeMovieCategoryViewState {
        return HomeMovieCategoryViewState(
            movieCategories = movieCategories.map {
                MovieCategoryLabelViewState(
                    itemId = it.ordinal,
                    isSelected = it == selectedMovieCategory,
                    categoryText = MovieCategoryLabelTextViewState.TextRes(getMovieCategoryRes(it))
                )
            },
            movies = movies.map { HomeMovieViewState(it.id, it.imageUrl, it.isFavorite) }
        )
    }

    private fun getMovieCategoryRes(selectedMovieCategory: MovieCategory): Int {
        return when (selectedMovieCategory) {
            POPULAR_STREAMING -> R.string.streaming
            POPULAR_ON_TV -> R.string.on_tv
            POPULAR_FOR_RENT -> R.string.for_rent
            POPULAR_IN_THEATRES -> R.string.in_theatres
            NOW_PLAYING_MOVIES -> R.string.movies
            NOW_PLAYING_TV -> R.string.TV
            UPCOMING_TODAY -> R.string.today
            UPCOMING_THIS_WEEK -> R.string.this_week
        }
    }
}