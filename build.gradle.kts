import dev.jonaz.vured.core.gradle.Versions

plugins {
    kotlin("jvm") version "1.5.0"
    kotlin("kapt") version "1.5.0"
}

group = "dev.jonaz.vured.core"

repositories {
    mavenCentral()
    maven(url = "https://m2.dv8tion.net/releases")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    kapt("org.atteo.classindex", "classindex", Versions.CLASS_INDEX)

    /** Kotlin **/
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-core", Versions.KOTLIN_COROUTINES)
    implementation("org.jetbrains.kotlin", "kotlin-reflect", Versions.KOTLIN)

    /** Discord **/
    implementation("com.sedmelluq", "lavaplayer", Versions.LAVA_PLAYER)

    /** Logging **/
    implementation("ch.qos.logback", "logback-classic", Versions.LOGBACK)

    /** Application **/
    implementation("io.insert-koin", "koin-core", Versions.KOIN)
    implementation("org.atteo.classindex", "classindex", Versions.CLASS_INDEX)
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
}
