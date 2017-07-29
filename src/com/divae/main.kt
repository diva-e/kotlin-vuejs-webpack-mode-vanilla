package com.divae

import vue.Vue
import vue.VNode
import runtime.wrappers.require

private class VueOptions {
    val el = "#app"
    val render = {
        h: (component: dynamic) -> VNode ->
        h(require("_/app.vue").default)
    }
}

fun main(args: Array<String>) {
    Vue(VueOptions())
}
