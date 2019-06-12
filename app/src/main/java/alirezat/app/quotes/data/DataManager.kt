package alirezat.app.quotes.data

import alirezat.app.quotes.helper.TestOpen
import alirezat.app.quotes.data.remote.RemoteRepository
import alirezat.app.quotes.domain.model.QuoteModel
import io.reactivex.Observable

@TestOpen
class DataManager(private val remoteRepository: RemoteRepository) : IDataManager {

    override fun getNewQuotes(): Observable<QuoteModel> {
        return remoteRepository.getQuote()
            .map { t -> QuoteModel(t.quoteText, t.quoteAuthor, remoteRepository.getImageUrl()) }
    }
}