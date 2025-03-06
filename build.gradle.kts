// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

// Set project-wide properties
extra.apply {
    set("compose_version", "1.5.1")
    set("kotlin_version", "1.9.0")
    set("nav_version", "2.7.5")
    set("compileSdk", 34)
    set("minSdk", 24)
    set("targetSdk", 34)
}
