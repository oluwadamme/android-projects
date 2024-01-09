import com.example.retrofitapp.Albums
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface AlbumService {
    @GET("/albums")
    suspend fun getAllAlbums() : Response<Albums>

    @GET("/albums")
    suspend fun getAllAlbumsByUserID(@Query("userId") userId:Int) : Response<Albums>

}