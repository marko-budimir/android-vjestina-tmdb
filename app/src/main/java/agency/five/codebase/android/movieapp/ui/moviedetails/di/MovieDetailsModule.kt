package agency.five.codebase.android.movieapp.ui.moviedetails.di

import agency.five.codebase.android.movieapp.data.di.BACKGROUND_DISPATCHER
import agency.five.codebase.android.movieapp.ui.moviedetails.MovieDetailsViewModel
import agency.five.codebase.android.movieapp.ui.moviedetails.mapper.MovieDetailsMapper
import agency.five.codebase.android.movieapp.ui.moviedetails.mapper.MovieDetailsMapperImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val movieDetailsModule = module {
    viewModel { (movieId: Int) ->
        MovieDetailsViewModel(
            movieId = movieId,
            movieRepository = get(),
            movieDetailsMapper = get(),
            bgDispatcher = get(named(BACKGROUND_DISPATCHER))
        )
    }
    single<MovieDetailsMapper> { MovieDetailsMapperImpl() }
}
