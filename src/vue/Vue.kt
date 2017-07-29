package vue

@JsModule("vue/dist/vue")
external class Vue(options: Any? = definedExternally) {
    fun `$emit`(event: String, args: Any? = definedExternally): Vue
    val `$data`: dynamic
    val `$props`: dynamic
    companion object {
        fun extend(options: Any): Vue
        fun component(id: String, options: Any): Vue
        fun component(id: String, options: Function<Any>): Vue
    }
}

@JsModule("vue/dist/vue")
external interface VNode {
}