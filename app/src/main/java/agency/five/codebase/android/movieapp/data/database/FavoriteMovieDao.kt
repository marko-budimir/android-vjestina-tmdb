package agency.five.codebase.android.movieapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteMovieDao {

    @Query("SELECT * FROM favorite_movies")
    fun getAll(): Flow<List<DbFavoriteMovie>>

    @Insert
    fun insert(movie: DbFavoriteMovie)

    @Query("DELETE FROM favorite_movies WHERE id = :movieId")
    fun delete(movieId: Int)
}
