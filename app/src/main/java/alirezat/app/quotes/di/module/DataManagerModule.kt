package alirezat.app.quotes.di.module

import alirezat.app.quotes.data.DataManager
import alirezat.app.quotes.data.remote.RemoteRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataManagerModule {

    @Singleton
    @Provides
    fun provideDataManager(): DataManager {
        return DataManager(provideRemoteRepository())
    }

    @Singleton
    @Provides
    fun provideRemoteRepository(): RemoteRepository {
        return RemoteRepository()
    }
}
