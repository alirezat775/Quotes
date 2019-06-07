package alirezat.app.quotes.di.module

import alirezat.app.quotes.data.remote.RemoteRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class DataManagerModule {

    private val BASE_URL: String = "https://quota.glitch.me"

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    fun provideService(): RemoteRepository.Api {
        return provideRetrofit().create(RemoteRepository.Api::class.java)
    }

}
