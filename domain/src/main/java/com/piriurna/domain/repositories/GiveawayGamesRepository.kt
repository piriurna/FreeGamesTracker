package com.piriurna.domain.repositories

import com.piriurna.domain.ApiNetworkResponse
import com.piriurna.domain.models.GiveawayGame

interface GiveawayGamesRepository {

    suspend fun getGiveaways() : ApiNetworkResponse<List<GiveawayGame>>

}