// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.9.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.7")
        classpath("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:1.9.0-1.0.13")
    }
}

tasks {
    register("clean", Delete::class) {
        delete(layout.buildDirectory)
    }
}
