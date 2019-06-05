package alirezat.app.quotes.data.remote

import alirezat.app.quotes.data.model.Quote
import retrofit2.Call

class ApiService(private val api: Api) {

    fun getQuote(): Call<Quote> {
        return api.getQuote()
    }
}