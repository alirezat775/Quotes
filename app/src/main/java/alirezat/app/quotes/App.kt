package alirezat.app.quotes

import alirezat.app.quotes.di.AppComponent
import alirezat.app.quotes.di.DaggerAppComponent
import alirezat.app.quotes.di.module.AppModule
import alirezat.app.quotes.di.module.NetworkModule
import android.app.Application

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule())
            .build()
    }

}