package com.divae.battleground

import vue.Vue
import kotlin.js.js
import runtime.wrappers.require

public class Battleground {

    class BattlegroundMethods {
        fun powerRangerMorphed() {
            val vue: Vue = js("this")
            val battlegroundData: BattlegroundData = vue.`$data`
            val props = vue.`$props`
            if (battlegroundData.startMorph) {
                StoryLine(battlegroundData, props.powerRangers, props.monsters).afterMorphing()
            }
        }
    }

    class BattlegroundComponents {
        val monsterComponent = require("_/monster-component/monster-component.vue").default
        val powerRangerComponent = require("_/power-ranger-component/power-ranger-component.vue").default
    }

    val props = arrayOf("imageSrc", "powerRangers", "monsters", "episodeName")
    val data = { -> BattlegroundData() }
    val methods = BattlegroundMethods()
    val components = BattlegroundComponents()

    fun created() {
        val vue: Vue = js("this")
        val battlegroundData: BattlegroundData = vue.`$data`
        val props = vue.`$props`
        StoryLine(battlegroundData, props.powerRangers, props.monsters).start()
    }
}