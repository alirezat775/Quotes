package alirezat.app.quotes.data.remote

import alirezat.app.quotes.BuildConfig
import alirezat.app.quotes.data.entity.QuoteEntity
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class RemoteRepository : IRemote {

    private fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BuildConfig.BASE_QUOTE_API)
            .build()
    }

    private fun provideService(): Api {
        return provideRetrofit().create(Api::class.java)
    }

    override fun getQuote(): Observable<QuoteEntity> {
        return provideService().getQuote()
    }

    override fun getImageUrl(): String {
        val rand = (1..500).random()
        return "https://picsum.photos/id/$rand/480/720?blur=2"
    }

    interface Api {
        @GET("/random")
        fun getQuote(): Observable<QuoteEntity>
    }
}