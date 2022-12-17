package agency.five.codebase.android.movieapp.data.network.model

import agency.five.codebase.android.movieapp.data.network.BASE_IMAGE_URL
import agency.five.codebase.android.movieapp.model.Movie
import agency.five.codebase.android.movieapp.model.MovieDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiMovieDetails(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("overview")
    val overview: String?,
    @SerialName("poster_path")
    val posterPath: String?,
    @SerialName("vote_average")
    val voteAverage: Float,
    @SerialName("release_date")
    val releaseDate: String,
    @SerialName("runtime")
    val runtime: Int?,
    @SerialName("spoken_languages")
    val spokenLanguages: List<Language>,
) {
    fun toMovieDetails() = MovieDetails(
        movie = Movie(
            id = id,
            title = title,
            overview = overview ?: "",
            imageUrl = "$BASE_IMAGE_URL/$posterPath",
            isFavorite = false,
        ),
        voteAverage = voteAverage,
        releaseDate = releaseDate,
        language = spokenLanguages[0].name,
        runtime = runtime ?: 0,
        crew = emptyList(),
        cast = emptyList(),
    )
}

@Serializable
data class Language(
    @SerialName("name")
    val name: String,
)
