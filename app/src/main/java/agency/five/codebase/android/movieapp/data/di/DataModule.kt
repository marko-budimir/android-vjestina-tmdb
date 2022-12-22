package agency.five.codebase.android.movieapp.data.di


import agency.five.codebase.android.movieapp.data.repository.MovieRepository
import agency.five.codebase.android.movieapp.data.repository.MovieRepositoryImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val BACKGROUND_DISPATCHER = "dispatcherIo"
const val MAIN_DISPATCHER = "dispatcherMain"

val dataModule = module {

    single<CoroutineDispatcher>(named(BACKGROUND_DISPATCHER)) { Dispatchers.IO }
    single<CoroutineDispatcher>(named(MAIN_DISPATCHER)) { Dispatchers.Main }

    single<MovieRepository> {
        MovieRepositoryImpl(
            movieService = get(),
            movieDao = get(),
            bgDispatcher = get(named(BACKGROUND_DISPATCHER))
        )
    }
}
