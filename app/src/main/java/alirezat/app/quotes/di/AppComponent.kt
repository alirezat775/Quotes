package alirezat.app.quotes.di

import alirezat.app.quotes.presentation.GetQuoteActivity
import alirezat.app.quotes.di.module.AppModule
import alirezat.app.quotes.di.module.DataManagerModule
import alirezat.app.quotes.di.module.UseCaseModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataManagerModule::class, UseCaseModule::class])
interface AppComponent {

    fun injectMainActivity(mainActivity: GetQuoteActivity)

}
