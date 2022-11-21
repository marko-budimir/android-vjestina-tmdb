package agency.five.codebase.android.movieapp.ui.moviedetails.mapper

import agency.five.codebase.android.movieapp.model.MovieDetails
import agency.five.codebase.android.movieapp.ui.component.ActorCardViewState
import agency.five.codebase.android.movieapp.ui.component.CrewItemViewState
import agency.five.codebase.android.movieapp.ui.moviedetails.MovieDetailsViewState


class MovieDetailsMapperImpl : MovieDetailsMapper {

    override fun toMovieDetailsViewState(movieDetails: MovieDetails): MovieDetailsViewState =
        MovieDetailsViewState(
            id = movieDetails.movie.id,
            imageUrl = movieDetails.movie.imageUrl,
            voteAverage = movieDetails.voteAverage,
            title = movieDetails.movie.title,
            overview = movieDetails.movie.overview,
            isFavorite = movieDetails.movie.isFavorite,
            crew = movieDetails.crew.map { CrewItemViewState(it.id, it.name, it.job) },
            cast = movieDetails.cast.map {
                ActorCardViewState(
                    it.id,
                    it.imageUrl,
                    it.name,
                    it.character
                )
            }
        )
}