package alirezat.app.quotes.data

import alirezat.app.quotes.data.model.Quote
import alirezat.app.quotes.data.remote.RemoteRepository
import io.reactivex.Observable

class DataManager(private val remoteRepository: RemoteRepository) : IDataManager {

    override fun getNewQuotes(): Observable<Quote> {
        return remoteRepository.getQuote()
    }
}