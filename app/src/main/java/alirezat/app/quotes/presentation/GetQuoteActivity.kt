package alirezat.app.quotes.presentation

import alirezat.app.quotes.App
import alirezat.app.quotes.R
import alirezat.app.quotes.domain.model.QuoteModel
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.facebook.shimmer.ShimmerFrameLayout
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class GetQuoteActivity : AppCompatActivity(), GetQuoteContract {

    private val TAG: String = this::class.java.name

    override fun shimmerView(): ShimmerFrameLayout {
        return shimmer_view_container
    }

    override fun getQuote(quoteModel: QuoteModel?) {
        Log.d(TAG, quoteModel?.quoteText)
        quote_tv.text = quoteModel?.quoteText
        Picasso.get()
            .load(quoteModel?.quoteImage)
            .into(quote_img)
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

    override fun onResume() {
        super.onResume()
        getQuotePresenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        getQuotePresenter.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        getQuotePresenter.onDestroyed()
    }
}