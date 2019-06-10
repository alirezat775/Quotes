package alirezat.app.quotes.data.remote

import alirezat.app.quotes.data.entity.QuoteEntity
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class RemoteRepository : IRemote {

    private val BASE_URL: String = "https://quota.glitch.me"

    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    private fun provideService(): Api {
        return provideRetrofit().create(Api::class.java)
    }

    override fun getQuote(): Observable<QuoteEntity> {
        return provideService().getQuote()
    }

    override fun getImageUrl(): String {
        val rand = (1..1000).random()
        return "https://picsum.photos/id/$rand/1080/1920?blur=9"
    }

    interface Api {
        @GET("/random")
        fun getQuote(): Observable<QuoteEntity>

    }
}