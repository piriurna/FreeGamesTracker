package com.piriurna.domain.models

data class GiveawayGame(
    val id: Int,
    val title: String,
    val description: String,
    val endDate: String,
    val image: String,
    val instructions: String,
    val giveawayUrl: String,
    val platforms: String,
    val publishedDate: String,
    val status: String,
    val thumbnail: String,
    val type: String,
    val users: Int,
    val worth: String
){


    companion object {
        val mocks = listOf(
            GiveawayGame(
                id = 0,
                title = "Warhammer: Vermintide 2",
                description = "Get the critically acclaimed Warhammer: Vermintide 2 for free via Steam! Vermintide 2 is a first-person melee action game with 4-player co-op and 5 different characters to choose. Don't miss this amazing game!",
                thumbnail = "https://www.gamerpower.com/offers/1/6363fb6194974.jpg",
                image = "https://www.gamerpower.com/offers/1b/6363fb6194974.jpg",
                instructions = "1. Download directly via Steam before expires (7 Nov).\r\n2. That's it! Enjoy your new Steam game!",
                giveawayUrl = "https://www.gamerpower.com/open/warhammer-vermintide-2",
                publishedDate = "2022-11-03 18:33:21",
                type = "Game",
                platforms = "PC, Steam",
                users = 4240,
                status = "Active",
                endDate = "2022-11-07 23:59:00",
                worth = "$29.99"
            ),
            GiveawayGame(
                id = 1,
                title = "Free Rising Storm 2: Vietnam",
                description = "Score Rising Storm 2: Vietnam for free via Epic Games Store! Rising Storm 2: Vietnam is a tactical shooter with 64-player battles and more than 20 maps! Grab it now!",
                thumbnail = "https://www.gamerpower.com/offers/1b/5f7f2a354cd03.jpg",
                image = "https://www.gamerpower.com/offers/1b/5f7f2a354cd03.jpg",
                instructions = "1. Login into your Epic Games Store account.\r\n2. Click the \"GET\" button to add the game to your library.",
                giveawayUrl = "https://www.gamerpower.com/open/free-rising-storm-2-vietnam-epic-store",
                publishedDate = "2022-11-03 17:20:20",
                type = "Game",
                platforms = "PC, Epic Games Store",
                users = 6410,
                status = "Active",
                endDate = "2022-11-10 16:17:31",
                worth = "$24.99",
            ),
            GiveawayGame(
                id = 2016,
                title = "Filament",
                description = "This week you can claim Filament for free on Epic Games Store! Filament is a Sci-fi single-player game with addictive puzzles. Check it out!",
                thumbnail = "https://www.gamerpower.com/offers/1/6363ec7b85134.jpg",
                image = "https://www.gamerpower.com/offers/1b/6363ec7b85134.jpg",
                instructions = "1. Login into your Epic Games Store account.\r\n2. Click the button to add the game to your library",
                giveawayUrl = "https://www.gamerpower.com/open/filament",
                publishedDate = "2022-11-03 17:29:47",
                type = "Game",
                platforms = "PC, Epic Games Store",
                users = 2300,
                status = "Active",
                endDate = "2022-11-10 23:59:00",
                worth = "$16.99",
            )
        )
    }
}