package alirezat.app.quotes.presentation

import alirezat.app.quotes.domain.model.QuoteModel
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

    fun onResume() {
        getQuoteContract!!.shimmerView().startShimmer()
    }

    fun onPause() {
        getQuoteContract!!.shimmerView().stopShimmer()
    }

    private fun getObserver(): Observer<QuoteModel> {
        return object : Observer<QuoteModel> {
            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: QuoteModel) {
                getQuoteContract?.getQuote(t)
            }

            override fun onError(e: Throwable) {
                getQuoteContract?.getError(e.message)
            }
        }
    }
}