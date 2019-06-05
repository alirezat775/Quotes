package alirezat.app.quotes.data.remote

import alirezat.app.quotes.data.model.Quote
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("https://quota.glitch.me/random")
    fun getQuote(): Call<Quote>
}