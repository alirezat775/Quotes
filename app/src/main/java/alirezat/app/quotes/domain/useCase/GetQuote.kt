package alirezat.app.quotes.domain.useCase

import alirezat.app.quotes.base.UseCase
import alirezat.app.quotes.data.IDataManager
import alirezat.app.quotes.data.model.Quote
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class GetQuote constructor(private val dataManager: IDataManager) :
    UseCase<GetQuote.Companion.RequestValue, GetQuote.Companion.ResponseValue, GetQuote.Companion.ErrorValue>() {

    private val TAG: String = this::class.java.name

    override fun executeUseCase(requestValue: UseCase.RequestValue) {
        dataManager.getNewQuotes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getObserver())
    }

    private fun getObserver(): Observer<Quote> {
        return object : Observer<Quote> {
            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Quote) {
                getUseCaseCallback().success(ResponseValue(t.quoteText, t.quoteAuthor))
            }

            override fun onError(e: Throwable) {
                getUseCaseCallback().error(ErrorValue(e.message))
            }
        }
    }

    companion object {

        class RequestValue : UseCase.RequestValue

        class ResponseValue(private val quoteText: String, private val quoteAuthor: String) :
            UseCase.ResponseValue {

            fun getQuoteText(): String {
                return quoteText
            }

            fun getQuoteAuthor(): String {
                return quoteAuthor
            }

        }

        class ErrorValue(private val error: String?) : UseCase.ErrorValue {

            fun getMessage(): String? {
                return error
            }
        }
    }

}