package alirezat.app.quotes.data

import alirezat.app.quotes.domain.model.QuoteModel
import io.reactivex.Observable

interface IDataManager {

    fun getNewQuotes(): Observable<QuoteModel>

}