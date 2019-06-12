package alirezat.app.quotes.domain.model

import alirezat.app.quotes.helper.TestOpen

@TestOpen
data class QuoteModel(val quoteText: String, val quoteAuthor: String, val quoteImage: String)