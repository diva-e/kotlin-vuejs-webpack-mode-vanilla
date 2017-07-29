package com.divae.powerranger

import vue.Vue
import kotlin.browser.window
import kotlin.js.js

public class PowerRanger {

    class PowerRangerData {
        var isMorphing = false
        var isMorphed = false
        var isUnMorphing = false
    }

    class PowerRangerWatch {
        fun startMorph(): Unit {
            val powerRangerData: PowerRangerData = js("this")
            if (!powerRangerData.isMorphed) {
                powerRangerData.isMorphing = true
                val powerRangerMethod: PowerRangerMethod = js("this")
                window.setTimeout(powerRangerMethod::morphed, 2000)
            }
        }

        fun startUnMorph(): Unit {
            val powerRangerData: PowerRangerData = js("this")
            if (powerRangerData.isMorphed) {
                powerRangerData.isUnMorphing = true
                val powerRangerMethod: PowerRangerMethod = js("this")
                window.setTimeout(powerRangerMethod::unMorphed, 500)
            }
        }
    }

    class PowerRangerMethod {
        fun morphed(): Unit {
            val vue: Vue = js("this")
            val powerRangerData: PowerRangerData = vue.`$data`
            powerRangerData.isMorphing = false
            powerRangerData.isMorphed = true
            vue.`$emit`("morphed")
        }

        fun unMorphed(): Unit {
            val powerRangerData: PowerRangerData = js("this")
            powerRangerData.isUnMorphing = false
            powerRangerData.isMorphed = false
        }
    }

    val props = arrayOf("name", "imageSrc", "morphingImageSrc", "morphedImageSrc", "startMorph", "startUnMorph", "emit")
    val data = { -> PowerRangerData() }
    val watch = PowerRangerWatch()
    val methods = PowerRangerMethod()
}