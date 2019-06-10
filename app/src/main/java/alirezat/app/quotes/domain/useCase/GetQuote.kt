package alirezat.app.quotes.domain.useCase

import alirezat.app.quotes.data.IDataManager
import alirezat.app.quotes.data.entity.QuoteEntity
import alirezat.app.quotes.domain.model.QuoteModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetQuote constructor(private val dataManager: IDataManager) {

    private val TAG: String = this::class.java.name

    fun executeUseCase(): Observable<QuoteModel>? {
        return dataManager.getNewQuotes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}