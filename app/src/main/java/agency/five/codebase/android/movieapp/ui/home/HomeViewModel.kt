package agency.five.codebase.android.movieapp.ui.home

import agency.five.codebase.android.movieapp.data.repository.MovieRepository
import agency.five.codebase.android.movieapp.model.MovieCategory
import agency.five.codebase.android.movieapp.ui.home.mapper.HomeScreenMapper
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class HomeViewModel(
    private val movieRepository: MovieRepository,
    private val homeScreenMapper: HomeScreenMapper,
    private val bgDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _popularCategoryViewState =
        MutableStateFlow(HomeMovieCategoryViewState(emptyList(), emptyList()))
    val popularCategoryViewState: StateFlow<HomeMovieCategoryViewState> =
        _popularCategoryViewState.asStateFlow()

    private val _nowPlayingCategoryViewState =
        MutableStateFlow(HomeMovieCategoryViewState(emptyList(), emptyList()))
    val nowPlayingCategoryViewState: StateFlow<HomeMovieCategoryViewState> =
        _nowPlayingCategoryViewState.asStateFlow()

    private val _upcomingCategoryViewState =
        MutableStateFlow(HomeMovieCategoryViewState(emptyList(), emptyList()))
    val upcomingCategoryViewState: StateFlow<HomeMovieCategoryViewState> =
        _upcomingCategoryViewState.asStateFlow()

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            movieRepository.popularMovies(MovieCategory.POPULAR_STREAMING).collect { movies ->
                _popularCategoryViewState.value = homeScreenMapper.toHomeMovieCategoryViewState(
                    movieCategories = popular,
                    selectedMovieCategory = MovieCategory.POPULAR_STREAMING,
                    movies = movies
                )
            }
        }

        viewModelScope.launch {
            movieRepository.nowPlayingMovies(MovieCategory.NOW_PLAYING_MOVIES).collect { movies ->
                _nowPlayingCategoryViewState.value = homeScreenMapper.toHomeMovieCategoryViewState(
                    movieCategories = nowPlaying,
                    selectedMovieCategory = MovieCategory.NOW_PLAYING_MOVIES,
                    movies = movies
                )
            }
        }

        viewModelScope.launch {
            movieRepository.upcomingMovies(MovieCategory.UPCOMING_TODAY).collect { movies ->
                _upcomingCategoryViewState.value = homeScreenMapper.toHomeMovieCategoryViewState(
                    movieCategories = upcoming,
                    selectedMovieCategory = MovieCategory.UPCOMING_TODAY,
                    movies = movies
                )
            }
        }
    }

    fun toggleFavorite(movieId: Int) {
        viewModelScope.launch(bgDispatcher) {
            movieRepository.toggleFavorite(movieId)
        }
    }
}
