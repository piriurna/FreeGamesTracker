package com.piriurna.freegamestracker.di

import com.piriurna.data.remote.GamerPowerApi
import com.piriurna.data.remote.sources.GamerPowerApiSource
import com.piriurna.freegamestracker.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideHttpClient() : OkHttpClient {

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)


        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .readTimeout(BuildConfig.READ_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(BuildConfig.CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideGamerPowerApi(okHttpClient: OkHttpClient): GamerPowerApi {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.GAMER_POWER_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GamerPowerApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTriviaApiSource(gamerPowerApi: GamerPowerApi): GamerPowerApiSource {
        return GamerPowerApiSource(gamerPowerApi)
    }

}