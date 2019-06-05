package alirezat.app.quotes.di

import alirezat.app.quotes.MainActivity
import alirezat.app.quotes.di.module.AppModule
import alirezat.app.quotes.di.module.NetworkModule
import android.app.Application
import dagger.Component

@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

    fun injectApplication(app: Application)

    fun injectMainActivity(mainActivity: MainActivity)

}