plugins {
    kotlin("jvm") version "2.4.20"
}

group = "io.github.yamin8000.quera"
version = "1.0.0"

repositories {
    try {
        if (uri("https://maven.myket.ir/").toURL().readText().isNotBlank()) {
            maven { url = uri("https://maven.myket.ir/") }
        }
    } catch (_: Exception) {
        //ignored
    }
    mavenCentral()
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:5.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")
}

kotlin {
    jvmToolchain(17)
}