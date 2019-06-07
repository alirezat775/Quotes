package alirezat.app.quotes

import alirezat.app.quotes.base.UseCase
import alirezat.app.quotes.base.UseCaseHandler
import alirezat.app.quotes.data.DataManager
import alirezat.app.quotes.domain.useCase.GetQuote
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    private val TAG: String = this::class.java.name

    @Inject
    lateinit var dataManager: DataManager

    private fun performDependencyInjection() {
        App.appComponent.injectMainActivity(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        UseCaseHandler.execute(GetQuote(dataManager), GetQuote.Companion.RequestValue(),
            object : UseCase.UseCaseCallback<GetQuote.Companion.ResponseValue, GetQuote.Companion.ErrorValue> {
                override fun success(responseValue: GetQuote.Companion.ResponseValue) {
                    Log.d(TAG, responseValue.getQuoteText())
                }

                override fun error(errorValue: GetQuote.Companion.ErrorValue) {
                    Log.d(TAG, errorValue.getMessage())
                }
            })
    }
}