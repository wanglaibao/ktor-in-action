package com.laibao.ktor

import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

/**
 * @author laibao wang
 */
fun main(args: Array<String>) {
    val server = embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {
                call.respondText("Hello World!",ContentType.Text.Plain)
            }
            get("/hello") {
                call.respondText("Hello World! 金戈，这里是Ktor WEB World,你可以来体验快感")
            }
        }
    }
    server.start(wait = true)
}

