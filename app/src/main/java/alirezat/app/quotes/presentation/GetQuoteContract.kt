package alirezat.app.quotes.presentation

import alirezat.app.quotes.data.model.Quote
import com.facebook.shimmer.ShimmerFrameLayout

interface GetQuoteContract {
    fun getQuote(quote: Quote?)
    fun getError(message: String?)
    fun shimmerView(): ShimmerFrameLayout
}
