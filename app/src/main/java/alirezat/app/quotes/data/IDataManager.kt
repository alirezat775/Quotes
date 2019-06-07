package alirezat.app.quotes.data

import alirezat.app.quotes.data.model.Quote
import io.reactivex.Observable

interface IDataManager {

    fun getNewQuotes(): Observable<Quote>

}