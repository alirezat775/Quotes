package alirezat.app.quotes.presentation

import alirezat.app.quotes.App
import alirezat.app.quotes.R
import alirezat.app.quotes.data.model.Quote
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import javax.inject.Inject


class GetQuoteActivity : AppCompatActivity(), GetQuoteContract {

    private val TAG: String = this::class.java.name

    @BindView(R.id.quote)
    lateinit var quoteTv: TextView

    override fun getQuote(quote: Quote?) {
        Log.d(TAG, quote?.quoteText)
        quoteTv.text = quote?.quoteText
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
        ButterKnife.bind(this)
        getQuotePresenter.onCreated(this)
        getQuotePresenter.getQuote()
    }

    override fun onDestroy() {
        super.onDestroy()
        getQuotePresenter.onDestroyed()
    }
}