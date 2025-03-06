plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.ccsimenson.mjodr"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ccsimenson.mjodr"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        // Enable downloading of Google Fonts
        manifestPlaceholders["GOOGLE_FONTS_API_KEY"] = ""
        manifestPlaceholders["FONT_FAMILY"] = "UnifrakturMaguntia"  // Norse-like font from Google Fonts
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["compose_version"].toString()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

android.applicationVariants.all {
    kotlin.sourceSets {
        getByName(name) {
            kotlin.srcDir("build/generated/ksp/$name/kotlin")
        }
    }
}

dependencies {
    val navVersion = rootProject.extra["nav_version"].toString()
    val composeVersion = rootProject.extra["compose_version"].toString()
    
    // Core Android dependencies
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")

    // Compose dependencies
    implementation(platform("androidx.compose:compose-bom:2024.02.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.runtime:runtime-livedata")
    implementation("androidx.compose.ui:ui-text-google-fonts:$composeVersion")
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")

    // Navigation
    implementation("androidx.navigation:navigation-compose:$navVersion")
    implementation("androidx.navigation:navigation-runtime-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    // ViewModels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")

    // Theme and UI enhancements
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.compose.material:material-ripple:$composeVersion")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.32.0")
    implementation("androidx.compose.ui:ui-text-google-fonts")
    implementation("com.google.accompanist:accompanist-drawablepainter:0.32.0")
    implementation("com.google.accompanist:accompanist-placeholder:0.32.0")

    // Testing dependencies
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.02.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
