plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "me.nikonbite.wscastle"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "application")

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.java-websocket:Java-WebSocket:1.5.4")
        implementation("com.fasterxml.jackson.core:jackson-databind:2.16.0")
    }

    kotlin {
        jvmToolchain(17)
    }
}

kotlin {
    jvmToolchain(17)
}