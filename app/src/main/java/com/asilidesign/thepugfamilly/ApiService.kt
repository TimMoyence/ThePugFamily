import com.asilidesign.thepugfamilly.CategoryResponse
import retrofit2.http.GET

interface ApiService {
    @GET("b/6760342bacd3cb34a8ba8657")
    suspend fun getCategories(): CategoryResponse
}