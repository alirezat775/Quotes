package alirezat.app.quotes.presentation

import alirezat.app.quotes.data.model.Quote
import alirezat.app.quotes.domain.useCase.GetQuote
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class GetQuotePresenter @Inject constructor(private val getQuote: GetQuote) {

    var getQuoteContract: GetQuoteContract? = null

    fun onCreated(getQuoteContract: GetQuoteContract) {
        this.getQuoteContract = getQuoteContract
    }

    fun onDestroyed() {
        getQuoteContract = null
    }

    fun getQuote() {
        getQuote.executeUseCase()?.subscribe(getObserver())
    }

    private fun getObserver(): Observer<Quote> {
        return object : Observer<Quote> {
            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Quote) {
                getQuoteContract?.getQuote(t)
            }

            override fun onError(e: Throwable) {
                getQuoteContract?.getError(e.message)
            }
        }
    }

}