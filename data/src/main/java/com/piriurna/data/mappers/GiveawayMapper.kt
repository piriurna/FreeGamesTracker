package com.piriurna.data.mappers

import com.piriurna.data.remote.dto.GiveawayGameDto
import com.piriurna.domain.models.GiveawayGame


fun List<GiveawayGameDto>.toGiveawayGame() : List<GiveawayGame> {
    return this.map { it.toGiveawayGame() }
}

fun GiveawayGameDto.toGiveawayGame() : GiveawayGame {
    return GiveawayGame(
        id = this.id,
        title = this.title,
        description = this.description,
        endDate = this.endDate,
        image = this.image,
        instructions = this.instructions,
        giveawayUrl = this.openGiveawayUrl,
        platforms = this.platforms,
        publishedDate = this.publishedDate,
        status = this.status,
        thumbnail = this.thumbnail,
        type = this.type,
        users = this.users,
        worth = this.worth
    )
}