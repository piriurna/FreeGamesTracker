package com.piriurna.data.remote

import com.piriurna.data.remote.dto.GiveawayGameListDto
import com.piriurna.data.remote.models.SortTypes
import retrofit2.http.GET
import retrofit2.http.Query

interface GamerPowerApi {

    @GET("giveaways")
    fun getGiveaways(
        @Query("sort-by") sortBy : String = SortTypes.Value.description
    ) : GiveawayGameListDto

}