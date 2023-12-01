package me.nikonbite.wscastle.client

import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.net.URI
import java.util.*

class WsCastleClient(serverUri: URI) : WebSocketClient(serverUri) {
    override fun onOpen(handshakedata: ServerHandshake?) {
        println("Connected to server: $uri")
    }

    override fun onMessage(message: String?) {
        println("Received message from server: $message")
    }

    override fun onClose(code: Int, reason: String?, remote: Boolean) {
        println("Connection closed. Code: $code, Reason: $reason")

        Timer().schedule(object : TimerTask() {
            override fun run() {
                if (!isOpen) {
                    println("Reconnecting to server...")
                    reconnect()
                }
            }
        }, 1000L)
    }

    override fun onError(ex: Exception?) {
        ex?.printStackTrace()
    }
}