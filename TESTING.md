# Mjöðr Testing Guide

## Testing Structure

### Unit Tests
Located in `app/src/test/java`
- `AbvCalculatorViewModelTest`: Tests core ABV calculation logic
- `NavDestinationTest`: Tests navigation destination configurations
- `RecipesViewModelTest`: Tests YouTube recipe search functionality
- `MeadHallViewModelTest`: Tests batch management functionality

### Instrumented Tests
Located in `app/src/androidTest/java`
- `NavGraphTest`: Tests navigation flow between screens
- `VikingComponentsTest`: Tests Viking-themed UI components
- `AbvCalculatorScreenTest`: Tests ABV calculator screen UI and functionality

## Running Tests

### Unit Tests
```bash
./gradlew test
```

### Instrumented Tests
```bash
./gradlew connectedDebugAndroidTest
```

### All Tests
```bash
./gradlew check
```

## Test Suites

### Unit Test Suite
```kotlin
class TestSuite : TestSuite() {
    init {
        addTest(AbvCalculatorViewModelTest::class.java)
        addTest(NavDestinationTest::class.java)
        addTest(RecipesViewModelTest::class.java)
        addTest(MeadHallViewModelTest::class.java)
    }
}
```

### Instrumented Test Suite
```kotlin
class AndroidTestSuite : TestSuite() {
    init {
        addTest(NavGraphTest::class.java)
        addTest(VikingComponentsTest::class.java)
        addTest(AbvCalculatorScreenTest::class.java)
    }
}
```

## Testing Best Practices

### Unit Tests
1. Test each ViewModel function independently
2. Mock external dependencies using Mockito
3. Verify state changes and side effects
4. Test error cases and edge conditions

### Instrumented Tests
1. Test navigation flows between screens
2. Verify UI component interactions
3. Test data persistence scenarios
4. Verify error states and loading states

### Performance Tests
1. Measure calculation performance
2. Test network request times
3. Verify database operations
4. Test memory usage

## Test Coverage Requirements

- Core features: 100% coverage
- UI components: 90% coverage
- Data operations: 100% coverage
- Error handling: 100% coverage

## Accessibility Testing

1. Test with TalkBack enabled
2. Verify color contrast ratios
3. Test keyboard navigation
4. Verify touch target sizes

## Security Testing

1. Test data encryption
2. Verify secure storage
3. Test network security
4. Verify user authentication

## Performance Testing

1. Measure app startup time
2. Test memory usage during navigation
3. Verify database query performance
4. Test network request timeouts
