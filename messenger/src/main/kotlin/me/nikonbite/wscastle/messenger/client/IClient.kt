package me.nikonbite.wscastle.messenger.client

import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.net.URI

abstract class IClient(serverUri: URI) : WebSocketClient(serverUri) {
    abstract fun opened(handshakedata: ServerHandshake?)
    abstract fun closed(code: Int, reason: String?, remote: Boolean)
    abstract fun received(message: String?)
    abstract fun error(ex: Exception?)
    abstract fun init()

    override fun onOpen(handshakedata: ServerHandshake?) = opened(handshakedata)
    override fun onClose(code: Int, reason: String?, remote: Boolean) = closed(code, reason, remote)
    override fun onMessage(message: String?) = received(message)
    override fun onError(ex: Exception?) = error(ex)
}