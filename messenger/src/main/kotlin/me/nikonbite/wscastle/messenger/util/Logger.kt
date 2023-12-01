package me.nikonbite.wscastle.messenger.util

class Logger {
    companion object {
        fun message(message: Any? = "") {
            println("@wscastle → $message")
        }
    }
}