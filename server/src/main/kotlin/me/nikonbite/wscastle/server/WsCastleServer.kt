package me.nikonbite.wscastle.server

import org.java_websocket.WebSocket
import org.java_websocket.handshake.ClientHandshake
import org.java_websocket.server.WebSocketServer
import java.net.InetSocketAddress

class WsCastleServer(port: Int): WebSocketServer(InetSocketAddress(port)) {
    override fun onOpen(conn: WebSocket?, handshake: ClientHandshake?) {
        println("New connection from: ${conn?.remoteSocketAddress}")
    }

    override fun onClose(conn: WebSocket?, code: Int, reason: String?, remote: Boolean) {
        println("Connection closed by ${if (remote) "remote peer" else "us"} Code: $code, Reason: $reason")
    }

    override fun onMessage(conn: WebSocket?, message: String?) {
        println("Received message from ${conn?.remoteSocketAddress}: $message")
    }

    override fun onError(conn: WebSocket?, ex: Exception?) {
        ex?.printStackTrace()
    }

    override fun onStart() {
        println("on start test")
    }
}