# Mjöðr Android App Testing Guide

This document provides instructions for running the test suites for the Viking-themed ABV calculator app.

## Test Structure

The testing suite is divided into two main categories:

1. **Unit Tests**: Tests that run on the JVM without requiring an Android device or emulator
2. **Instrumented Tests**: Tests that run on an Android device or emulator

### Unit Tests

Located in `app/src/test/java/com/ccsimenson/mjodr/`:

- **AbvCalculatorViewModelTest**: Tests the core ABV calculation logic
- **NavDestinationTest**: Tests the navigation destination configurations
- **RecipesViewModelTest**: Tests the YouTube recipe search functionality
- **MeadHallViewModelTest**: Tests the batch management functionality

### Instrumented Tests

Located in `app/src/androidTest/java/com/ccsimenson/mjodr/`:

- **NavGraphTest**: Tests the navigation flow between screens
- **VikingComponentsTest**: Tests the Viking-themed UI components
- **AbvCalculatorScreenTest**: Tests the ABV calculator screen UI and functionality

## Running the Tests

### Running Unit Tests

To run all unit tests:

```bash
./gradlew test
```

To run a specific test class:

```bash
./gradlew test --tests "com.ccsimenson.mjodr.AbvCalculatorViewModelTest"
```

### Running Instrumented Tests

Make sure you have an Android device connected or an emulator running.

To run all instrumented tests:

```bash
./gradlew connectedAndroidTest
```

To run a specific instrumented test class:

```bash
./gradlew connectedAndroidTest -Pandroid.testInstrumentationRunnerArguments.class=com.ccsimenson.mjodr.ui.screens.AbvCalculatorScreenTest
```

## Test Reports

After running the tests, you can find the test reports at:

- Unit Tests: `app/build/reports/tests/testDebugUnitTest/index.html`
- Instrumented Tests: `app/build/reports/androidTests/connected/index.html`

## Adding New Tests

When adding new tests:

1. For unit tests, add them to `app/src/test/java/com/ccsimenson/mjodr/`
2. For instrumented tests, add them to `app/src/androidTest/java/com/ccsimenson/mjodr/`
3. Update the appropriate test suite class:
   - Unit tests: `TestSuite.kt`
   - Instrumented tests: `AndroidTestSuite.kt`

## Testing Best Practices

1. Follow the AAA pattern (Arrange, Act, Assert)
2. Test one thing per test method
3. Use descriptive test method names
4. Keep tests independent of each other
5. Mock external dependencies

## Viking Theme Testing Guidelines

When testing Viking-themed components, verify:

1. Colors match the Viking theme:
   - Background: Dark wood brown (#2C1810)
   - Buttons: Light wood brown (#B08968)
   - Accent: Soft gold (#DAA520)
   - Hover/Active: Deep red (#8B0000)
   - Text: Dark brown on light backgrounds, Parchment (#F5E6D3) on dark
   
2. Text elements use the correct Norse-inspired naming:
   - "Mjöðr Calculator"
   - "Sacred Measurements"
   - "Wisdom of Odin"
   - "Ancient Recipes"
   - "Mead Hall"
   - "Runes of Knowledge"
