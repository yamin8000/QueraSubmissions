plugins {
    kotlin("jvm")
}

group = "io.github.yamin8000.quera"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.12")
}

kotlin {
    jvmToolchain(17)
}