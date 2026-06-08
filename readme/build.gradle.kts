plugins {
    kotlin("jvm") version "2.0.0"
}

group = "io.github.yamin8000.quera"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:5.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0-RC")
}

kotlin {
    jvmToolchain(17)
}