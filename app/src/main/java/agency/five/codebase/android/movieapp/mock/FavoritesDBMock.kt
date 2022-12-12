package agency.five.codebase.android.movieapp.mock

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

object FavoritesDBMock {

    private val _favoritesIds = MutableStateFlow(setOf<Int>())
    val favoriteIds: StateFlow<Set<Int>> = _favoritesIds.asStateFlow()

    fun insert(movieId: Int) = _favoritesIds.update { it.plus(movieId) }
    fun delete(movieId: Int) = _favoritesIds.update { it.minus(movieId) }
}
