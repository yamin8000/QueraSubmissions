plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version ("1.9.22")
}

group = "io.github.yamin8000"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}