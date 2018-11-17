package com.laibao.ktor.introduction

import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main(args: Array<String>) {
    val server = embeddedServer(Netty, port = 8080) {
        routing {
            plainTextRoute()
            htmlRoute()
        }
    }
    server.start(wait = true)
}

fun Routing.plainTextRoute() {
    get("/plain") {
        call.respondText("Hello World!")
    }
}

fun Routing.htmlRoute() {
    get("/html") {
        call.respondText("<h1>Hello World!</h1>", contentType = ContentType.Text.Html)
    }
}