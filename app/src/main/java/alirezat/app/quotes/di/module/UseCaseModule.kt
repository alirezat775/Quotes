package alirezat.app.quotes.di.module

import alirezat.app.quotes.data.DataManager
import alirezat.app.quotes.domain.useCase.GetQuote
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetQuote(dataManager: DataManager): GetQuote {
        return GetQuote(dataManager)
    }
}