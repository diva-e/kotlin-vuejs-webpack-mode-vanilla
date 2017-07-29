package com.divae

import axios.axios
import kotlin.js.js
import kotlin.js.Json
import vue.Vue
import runtime.wrappers.require

public class App {

    class AppData {
        var battelgroundImageSrc = ""
        var battlegroundIsReady = false
        var powerRangers: dynamic = ""
        var monsters: dynamic = ""
        var episodeName = ""
    }

    class AppMethods {
        fun generate() {
            val appData: AppData = js("this")
            axios.get("/generate").then(fun(response) {
                val data: Json = response.data
                appData.battelgroundImageSrc = data.get("battlePlaceImage") as String
                appData.powerRangers = data.get("team")
                appData.monsters = data.get("monster")
                appData.episodeName = data.get("name") as String

                appData.battlegroundIsReady = true
            })
        }
    }

    class AppComponents {
        val battlegroundComponent = require("_/battleground-component/battleground-component.vue").default
    }

    val data = { -> AppData() }
    val methods = AppMethods()
    val components = AppComponents()
}