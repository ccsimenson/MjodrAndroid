// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.navigation.safeArgs) apply false
    alias(libs.plugins.hilt.android) apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.9.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.20")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.7")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.50")
    }
}

tasks {
    register("clean", Delete::class) {
        delete(layout.buildDirectory)
    }
}
