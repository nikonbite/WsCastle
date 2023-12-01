package me.nikonbite.wscastle.server

const val PORT = 8080

fun main() {
    val wsCastleServer = WsCastleServer(PORT)
    wsCastleServer.start();

    println("WebSocket server is running on port $PORT")
}