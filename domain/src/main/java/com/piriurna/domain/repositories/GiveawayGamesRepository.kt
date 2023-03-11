package com.piriurna.domain.repositories

import com.piriurna.domain.ApiNetworkResponse
import com.piriurna.domain.models.Game

interface GiveawayGamesRepository {

    suspend fun getGiveaways() : ApiNetworkResponse<List<Game>>

}