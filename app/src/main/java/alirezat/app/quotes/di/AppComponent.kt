package alirezat.app.quotes.di

import alirezat.app.quotes.MainActivity
import alirezat.app.quotes.di.module.AppModule
import alirezat.app.quotes.di.module.DataManagerModule
import android.app.Application
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataManagerModule::class])
interface AppComponent {

    fun injectMainActivity(mainActivity: MainActivity)

}
