package alirezat.app.quotes.presentation

import alirezat.app.quotes.data.model.Quote

interface GetQuoteContract {
    fun getQuote(quote: Quote?)
    fun getError(message: String?)
}
