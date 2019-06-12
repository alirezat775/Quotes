package alirezat.app.quotes

import alirezat.app.quotes.data.DataManager
import alirezat.app.quotes.data.remote.RemoteRepository
import alirezat.app.quotes.domain.model.QuoteModel
import alirezat.app.quotes.domain.useCase.GetQuote
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class GetQuoteUnitTest {

    @Mock
    lateinit var dataManager: DataManager

    @Mock
    lateinit var remoteRepository: RemoteRepository

    @Mock
    lateinit var getQuote: GetQuote

    @Mock
    lateinit var quoteModel: QuoteModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        dataManager = DataManager(remoteRepository)
    }

    @Test
    fun executeGetQuoteUseCase() {
        Mockito.`when`(getQuote.executeUseCase()).thenReturn(Observable.just(quoteModel))
    }
}