package alirezat.app.quotes.data

import alirezat.app.quotes.data.remote.ApiService

class DataManager(val apiService: ApiService) : IDataManager {

    override fun getNewQuotes() {
        apiService.getQuote()
    }
}