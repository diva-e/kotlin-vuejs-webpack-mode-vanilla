package axios

import kotlin.js.Promise

@JsModule("axios")
external interface Axios {
    fun get(url: String): Promise<Response>
}

@JsModule("axios")
external class Response {
    val data: dynamic
    val status: Number
    val statusText: String
    val headers: dynamic
    val config: dynamic
    val request: dynamic
}

@JsModule("axios")
external val axios: Axios