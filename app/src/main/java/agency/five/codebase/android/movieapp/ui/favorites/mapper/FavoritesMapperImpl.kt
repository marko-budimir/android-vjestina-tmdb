package agency.five.codebase.android.movieapp.ui.favorites.mapper

import agency.five.codebase.android.movieapp.model.Movie
import agency.five.codebase.android.movieapp.ui.component.MovieCardViewState
import agency.five.codebase.android.movieapp.ui.favorites.FavoritesMovieViewState
import agency.five.codebase.android.movieapp.ui.favorites.FavoritesViewState

class FavoritesMapperImpl : FavoritesMapper {

    override fun toFavoritesViewState(favoritesMovies: List<Movie>): FavoritesViewState =
        FavoritesViewState(
            favoritesMovies.map {
                FavoritesMovieViewState(it.id, MovieCardViewState(it.imageUrl, it.isFavorite))
            }
        )
}
