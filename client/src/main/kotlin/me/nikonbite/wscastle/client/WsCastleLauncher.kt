package me.nikonbite.wscastle.client

import me.nikonbite.wscastle.messenger.bundle.impl.TestBundle
import java.net.URI
import java.util.*

fun main() {
    val serverUri = URI("ws://localhost:8080")
    val client = WsCastleClient(serverUri)
    client.connect()

    client.send(TestBundle("Name", 11).write())

    val scanner = Scanner(System.`in`)
    while (true) {
        print("@wscore -> ")
        val input = scanner.nextLine()
        if (input.equals("exit", ignoreCase = true)) {
            break
        }
        client.send(input)
    }

    client.close()
}