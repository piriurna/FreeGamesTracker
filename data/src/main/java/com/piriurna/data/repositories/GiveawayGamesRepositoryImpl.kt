package com.piriurna.data.repositories

import com.piriurna.data.mappers.toApiNetworkError
import com.piriurna.data.remote.GTException
import com.piriurna.data.mappers.toGiveawayGame
import com.piriurna.data.remote.sources.GamerPowerApiSource
import com.piriurna.domain.ApiNetworkResponse
import com.piriurna.domain.models.Game
import com.piriurna.domain.repositories.GiveawayGamesRepository
import javax.inject.Inject

class GiveawayGamesRepositoryImpl @Inject constructor(
    private val gamerPowerApiSource: GamerPowerApiSource
) : GiveawayGamesRepository {

    override suspend fun getGiveaways() : ApiNetworkResponse<List<Game>> {
        return try {
            ApiNetworkResponse(data = gamerPowerApiSource.getGiveaways().toGiveawayGame())
        } catch (e : GTException) {
            ApiNetworkResponse(
                error = e.toApiNetworkError()
            )
        }
    }
}