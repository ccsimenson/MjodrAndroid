# Mjöðr - Viking Mead Calculator

A modern Android app built with Jetpack Compose that helps Viking enthusiasts calculate alcohol by volume (ABV) for their mead recipes.

## Features

- ABV Calculator with temperature correction
- Traditional Recipe Search (YouTube integration)
- Batch Management with fermentation tracking
- Viking-themed UI with authentic Norse aesthetic
- Historical Brewing Information
- Data persistence with Room Database
- Offline support

## Tech Stack

- **UI**: Jetpack Compose with Material 3
- **Architecture**: MVVM with Clean Architecture
- **Dependency Injection**: Hilt
- **Data Persistence**: Room Database
- **Network**: Retrofit + OkHttp
- **State Management**: ViewModel + StateFlow
- **Navigation**: Jetpack Navigation Compose
- **Testing**: JUnit + Espresso + Compose Testing

## Getting Started

### Prerequisites

- Android Studio Electric Eel | 2022.1.1 or higher
- JDK 17 or higher
- Android SDK 34 (API level 34)
- Gradle 8.9.0 or higher

### Installation

1. Clone the repository
2. Open the project in Android Studio
3. Create a `local.properties` file in the root directory with your development settings
4. Create a `keystore.properties` file in the `app` directory with your signing configuration
5. Build and run the app

### Building the App

```bash
./gradlew clean build
```

### Running Tests

```bash
./gradlew test
./gradlew connectedDebugAndroidTest
```

## Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/         # Source code
│   │   ├── res/          # Resources
│   │   └── AndroidManifest.xml
│   ├── androidTest/      # Instrumentation tests
│   └── test/             # Unit tests
├── build.gradle.kts      # App-level build configuration
└── proguard-rules.pro    # ProGuard rules

```

## Contributing

Please read our [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct and the process for submitting pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Special thanks to the Android Developer community for their excellent documentation and support
- Thanks to all contributors who have helped improve this project
