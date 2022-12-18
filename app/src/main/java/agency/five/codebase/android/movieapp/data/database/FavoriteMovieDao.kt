package agency.five.codebase.android.movieapp.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteMovieDao {

    @Query("SELECT * FROM favorite_movies")
    suspend fun getAll(): Flow<List<DbFavoriteMovie>>

    @Insert
    suspend fun insert(movie: DbFavoriteMovie)

    @Delete
    suspend fun delete(movie: DbFavoriteMovie)
}
