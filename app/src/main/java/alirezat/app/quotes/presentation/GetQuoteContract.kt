package alirezat.app.quotes.presentation

import alirezat.app.quotes.domain.model.QuoteModel
import com.facebook.shimmer.ShimmerFrameLayout

interface GetQuoteContract {
    fun getQuote(quoteModel: QuoteModel?)
    fun getError(message: String?)
    fun shimmerView(): ShimmerFrameLayout
}
