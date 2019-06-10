package alirezat.app.quotes.presentation

import alirezat.app.quotes.App
import alirezat.app.quotes.R
import alirezat.app.quotes.domain.model.QuoteModel
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.facebook.shimmer.ShimmerFrameLayout
import javax.inject.Inject


class GetQuoteActivity : AppCompatActivity(), GetQuoteContract {

    private val TAG: String = this::class.java.name

    @BindView(R.id.quote_tv)
    lateinit var quoteTv: TextView

    @BindView(R.id.shimmer_view_container)
    lateinit var shimmerViewContainer: ShimmerFrameLayout

    override fun shimmerView(): ShimmerFrameLayout {
        return shimmerViewContainer
    }

    override fun getQuote(quoteModel: QuoteModel?) {
        Log.d(TAG, quoteModel?.quoteText)
        quoteTv.text = quoteModel?.quoteText
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