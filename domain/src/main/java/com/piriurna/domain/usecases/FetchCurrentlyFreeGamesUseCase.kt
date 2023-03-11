package com.piriurna.domain.usecases

import com.piriurna.domain.Resource
import com.piriurna.domain.models.Game
import com.piriurna.domain.repositories.GiveawayGamesRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchCurrentlyFreeGamesUseCase @Inject constructor(
    private val giveawayGamesRepository: GiveawayGamesRepository
){

    operator fun invoke() = flow<Resource<List<Game>>> {
        emit(Resource.Loading())

        val giveawayGamesResponse = giveawayGamesRepository.getGiveaways()

        giveawayGamesResponse.data?.let {
            emit(Resource.Success(data = it))
        } ?: run {
            val error = giveawayGamesResponse.error
            emit(Resource.Error(code = error.code, message = error.message?:ERROR_FETCHING_GIVEAWAY_GAMES))
        }
    }


    companion object {
        const val ERROR_FETCHING_GIVEAWAY_GAMES = "Error fetching giveaway games"
    }
}