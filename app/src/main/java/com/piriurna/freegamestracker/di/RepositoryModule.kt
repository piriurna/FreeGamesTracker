package com.piriurna.freegamestracker.di

import com.piriurna.data.remote.sources.GamerPowerApiSource
import com.piriurna.data.repositories.GiveawayGamesRepositoryImpl
import com.piriurna.domain.repositories.GiveawayGamesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideGiveawayGamesRepository(gamerPowerApiSource: GamerPowerApiSource): GiveawayGamesRepository {
        return GiveawayGamesRepositoryImpl(gamerPowerApiSource)
    }
}