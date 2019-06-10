package alirezat.app.quotes.data.remote

import alirezat.app.quotes.data.entity.QuoteEntity
import io.reactivex.Observable

interface IRemote {

    fun getQuote(): Observable<QuoteEntity>

    fun getImageUrl(): String
}