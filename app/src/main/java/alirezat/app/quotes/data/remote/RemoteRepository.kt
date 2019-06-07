package alirezat.app.quotes.data.remote

import alirezat.app.quotes.data.model.Quote
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class RemoteRepository {

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

    fun getQuote(): Observable<Quote> {
        return provideService().getQuote()
    }

    interface Api {

        @GET("/random")
        fun getQuote(): Observable<Quote>
    }
}