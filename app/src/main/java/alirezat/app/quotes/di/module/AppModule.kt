package alirezat.app.quotes.di.module

import alirezat.app.quotes.base.UseCaseHandler
import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class AppModule @Inject constructor(private val application: Application) {

    @Singleton
    @Provides
    fun provideContext(): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideUseCaseHandler(): UseCaseHandler {
        return UseCaseHandler
    }
}
