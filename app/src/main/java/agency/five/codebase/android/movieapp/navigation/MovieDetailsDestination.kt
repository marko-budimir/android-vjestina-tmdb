package agency.five.codebase.android.movieapp.navigation

object MovieDetailsDestination : MovieAppDestination(MOVIE_DETAILS_ROUTE_WITH_PARAMS) {
    fun createNavigationRoute(movieId: Int): String = "$MOVIE_DETAILS_ROUTE/$movieId"
}
