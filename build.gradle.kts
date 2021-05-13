import dev.jonaz.vured.util.gradle.Versions
import com.vanniktech.maven.publish.SonatypeHost

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("com.vanniktech:gradle-maven-publish-plugin:0.15.1")
    }
}

plugins {
    kotlin("jvm") version "1.5.0"
    kotlin("kapt") version "1.5.0"
    id("com.vanniktech.maven.publish") version "0.15.1"
}

group = "dev.jonaz.vured.util"

repositories {
    mavenCentral()
    maven("https://m2.dv8tion.net/releases")
}

dependencies {
    compileOnly(kotlin("stdlib-jdk8"))

    /** Kotlin **/
    compileOnly("org.jetbrains.kotlin", "kotlin-reflect", Versions.KOTLIN)

    /** Discord **/
    compileOnly("net.dv8tion", "JDA", Versions.JDA)
    compileOnly("com.sedmelluq", "lavaplayer", Versions.LAVA_PLAYER)

    /** Logging **/
    compileOnly("ch.qos.logback", "logback-classic", Versions.LOGBACK)

    /** Application **/
    compileOnly("io.insert-koin", "koin-core", Versions.KOIN)
    compileOnly("com.sksamuel.hoplite", "hoplite-core", Versions.HOPLITE)
    compileOnly("com.sksamuel.hoplite", "hoplite-hocon", Versions.HOPLITE)
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
}

allprojects {
    plugins.withId("com.vanniktech.maven.publish") {
        mavenPublish {
            sonatypeHost = SonatypeHost.S01
        }
    }
}
