package alirezat.app.quotes.presentation

import alirezat.app.quotes.App
import alirezat.app.quotes.R
import alirezat.app.quotes.data.model.Quote
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject


class GetQuoteActivity : AppCompatActivity(), GetQuoteContract {

    private val TAG: String = this::class.java.name

    override fun getQuote(quote: Quote?) {
        Log.d(TAG, quote?.quoteText)
    }

    override fun getError(message: String?) {
        Log.d(TAG, message)
    }

    @Inject
    lateinit var getQuotePresenter: GetQuotePresenter

    private fun performDependencyInjection() {
        App.appComponent.injectMainActivity(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getQuotePresenter.onCreated(this)
        getQuotePresenter.getQuote()
    }

    override fun onDestroy() {
        super.onDestroy()
        getQuotePresenter.onDestroyed()
    }
}