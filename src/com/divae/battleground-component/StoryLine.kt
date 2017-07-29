package com.divae.battleground

import com.divae.battleground.BattlegroundData
import kotlin.browser.window

public class StoryLine(private val battlegroundData: BattlegroundData, private val powerRangers: dynamic, private val monsters: dynamic) {

    private fun monstersGrows() {
        battlegroundData.storyText = "Wuhahaha"
        battlegroundData.monstersBig = true
        window.setTimeout({
            battlegroundData.storyText = "Oh nein"
            window.setTimeout(this::megazordArriving, 3000)
        }, 3000)
    }

    private fun megazordArriving() {
        battlegroundData.storyText = ""
        battlegroundData.megazordArrived = true
        window.setTimeout({
            battlegroundData.monstersKilled = true
        }, 3000)
    }

    private fun monstersArriving() {
        battlegroundData.monstersArrived = true
        window.setTimeout({
            battlegroundData.storyText = monsters.taunt
            battlegroundData.monsterIsSaying = true
            window.setTimeout({
                battlegroundData.storyText = ""
                window.setTimeout(this::powerRangersArriving, 3000)
            }, 3000)
        }, 3000)
    }

    private fun powerRangersArriving() {
        battlegroundData.powerRangersArrived = true
        battlegroundData.storyText = ""
        window.setTimeout({
            battlegroundData.storyText = powerRangers.taunt
            battlegroundData.monsterIsSaying = false
            battlegroundData.powerRangerIsSaying = true
            window.setTimeout({
                battlegroundData.storyText = "Es ist morphin' Zeit"
                window.setTimeout({
                    battlegroundData.storyText = ""
                    battlegroundData.startMorph = true
                }, 3000)
            }, 3000)
        }, 3000)
    }

    public fun start() {
        window.setTimeout(this::monstersArriving, 3000)
    }

    public fun afterMorphing() {
        battlegroundData.startMorph = false
        window.setTimeout({
            battlegroundData.storyText = powerRangers.name
            window.setTimeout(this::monstersGrows, 3000)
        }, 3000)
    }
}