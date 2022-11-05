package com.piriurna.data.remote.sources

import com.piriurna.data.remote.GamerPowerApi
import com.piriurna.data.remote.HandleApi.safeApiCall
import com.piriurna.data.remote.dto.GiveawayGameListDto
import javax.inject.Inject

class GamerPowerApiSource @Inject constructor(
    private var gamerPowerApi: GamerPowerApi
) {

    suspend fun getGiveaways() : GiveawayGameListDto {
        return safeApiCall { gamerPowerApi.getGiveaways() }
    }
}