package me.nikonbite.wscastle.messenger.server

import org.java_websocket.WebSocket
import org.java_websocket.handshake.ClientHandshake
import org.java_websocket.server.WebSocketServer
import java.net.InetSocketAddress

abstract class IServer(port: Int) : WebSocketServer(InetSocketAddress(port)) {
    abstract fun opened(conn: WebSocket?, handshake: ClientHandshake?)
    abstract fun closed(conn: WebSocket?, code: Int, reason: String?, remote: Boolean)
    abstract fun received(conn: WebSocket?, message: String?)
    abstract fun error(conn: WebSocket?, ex: Exception?)
    abstract fun init()

    override fun onOpen(conn: WebSocket?, handshake: ClientHandshake?) = opened(conn, handshake)
    override fun onClose(conn: WebSocket?, code: Int, reason: String?, remote: Boolean) = closed(conn, code, reason, remote)
    override fun onMessage(conn: WebSocket?, message: String?) = received(conn, message)
    override fun onError(conn: WebSocket?, ex: Exception?) = error(conn, ex)
    override fun onStart() = init()
}