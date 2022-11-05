package com.piriurna.domain.usecases

import com.piriurna.domain.ApiNetworkError
import com.piriurna.domain.ApiNetworkResponse
import com.piriurna.domain.Resource
import com.piriurna.domain.models.GiveawayGame
import com.piriurna.domain.repositories.GiveawayGamesRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class FetchCurrentlyFreeGamesUseCaseTest {

    private lateinit var fetchCurrentlyFreeGamesUseCase: FetchCurrentlyFreeGamesUseCase
    private lateinit var giveawayGamesRepository: GiveawayGamesRepository

    @Before
    fun setUp() {
        giveawayGamesRepository = mock()
        fetchCurrentlyFreeGamesUseCase = FetchCurrentlyFreeGamesUseCase(giveawayGamesRepository = giveawayGamesRepository)
    }


    @ExperimentalCoroutinesApi
    @Test
    fun `ask for data and receive data`() = runBlockingTest {
        whenever(giveawayGamesRepository.getGiveaways()).thenReturn(
            ApiNetworkResponse(data = GiveawayGame.mocks)
        )


        val emissions = fetchCurrentlyFreeGamesUseCase().toList()
        var result = (emissions[0] as Resource)

        assert(result is Resource.Loading)

        result = (emissions[1] as Resource)
        val giveawayGames = (result.data as? List<GiveawayGame>)
        assert(!giveawayGames.isNullOrEmpty())

        verify(giveawayGamesRepository, times(1)).getGiveaways()
    }


    @ExperimentalCoroutinesApi
    @Test
    fun `ask for data and receive error`() = runBlockingTest {
        whenever(giveawayGamesRepository.getGiveaways()).thenReturn(
            ApiNetworkResponse(error = ApiNetworkError(code = 404, message = FetchCurrentlyFreeGamesUseCase.ERROR_FETCHING_GIVEAWAY_GAMES))
        )


        val emissions = fetchCurrentlyFreeGamesUseCase().toList()
        var result = (emissions[0] as Resource)

        assert(result is Resource.Loading)

        result = (emissions[1] as Resource.Error)
        assert(result.code == 404 && result.message == FetchCurrentlyFreeGamesUseCase.ERROR_FETCHING_GIVEAWAY_GAMES)

        verify(giveawayGamesRepository, times(1)).getGiveaways()
    }

}