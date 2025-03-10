# Mjöðr Android App Roadmap

## Feature Implementation Plan

### 1. ABV Calculator (Sacred Measurements)
- [x] UI Components and Navigation
- [x] Implement temperature correction functionality
- [x] Add input validation with Viking-themed error messages
- [x] Implement Plato conversion display
- [x] Add historical context information about Viking brewing methods
# 2. Recipes (Ancient Recipes)
- [x] UI Components and Navigation
- [x] Implement YouTube API integration for mead recipes
- [x] Add local storage for favorite recipes
- [x] Create pre-populated list of traditional Viking mead recipes
- [x] Implement recipe filtering by type (traditional, modern, spiced, etc.)
- [x] Add recipe sharing functionality

### 3. Mead Hall (Batch Management)
- [x] UI Components and Navigation
- [ ] Implement local database for batch storage
- [ ] Create batch tracking functionality (start date, readings, status)
- [ ] Add measurement tracking with gravity and temperature
- [ ] Implement batch status updates (primary, secondary, aging, bottled)
- [ ] Add notifications for batch milestones
- [ ] Implement batch statistics and reporting

### 4. Help (Wisdom of Odin)
- [x] UI Components and Navigation
- [ ] Create comprehensive help content with Viking theme
- [ ] Add brewing glossary with Norse terminology
- [ ] Implement troubleshooting guide for common mead issues
- [ ] Add historical context about Viking brewing traditions
- [ ] Create FAQ section with Viking-themed responses

## Data Models Implementation
- [ ] Create MeadBatch data class and repository
- [ ] Implement GravityMeasurement data class
- [ ] Create BatchStatus enum with Viking-themed status names
- [ ] Implement Recipe data class and repository
- [ ] Create YoutubeVideo data model for recipe integration

## API Integration
- [ ] Set up YouTube Data API for recipe search
- [ ] Implement proper API key management
- [ ] Add caching for API responses to reduce quota usage
- [ ] Implement error handling for API failures

## Final Steps Before Publishing

### 1. Testing & Quality Assurance
- [  ] Run all unit tests: `./gradlew test`
- [  ] Run all instrumented tests: `./gradlew connectedAndroidTest`
- [  ] Perform manual testing on physical devices
- [  ] Test on different screen sizes and Android versions

### 2. App Assets & Branding
- [  ] Create Viking-themed app icon (512x512px for Play Store)
- [  ] Design splash screen with Norse imagery
- [  ] Generate all required icon sizes using Android Studio
- [  ] Update app name in strings.xml to "Mjöðr: Viking Mead Calculator"

### 3. Release Preparation
- [  ] Update versionCode and versionName in build.gradle
- [  ] Create signing key: `keytool -genkey -v -keystore mjodr-release-key.keystore -alias mjodr -keyalg RSA -keysize 2048 -validity 10000`
- [  ] Configure signing in build.gradle
- [  ] Generate signed APK: `./gradlew assembleRelease`
- [  ] Test signed APK on device before publishing

### 4. Play Store Requirements
- [  ] Create privacy policy (required for YouTube API usage)
- [  ] Take screenshots for Play Store listing (different devices)
- [  ] Write app description with Viking theme
- [  ] Create feature graphic (1024x500px)
- [  ] Set up content rating questionnaire

## Future Enhancements (v2.0+)

### Visual Enhancements
- [  ] Add animated transitions between screens (parchment unfurling effect)
- [  ] Incorporate Norse runes as decorative elements
- [  ] Add Viking illustrations for empty states
- [  ] Create custom progress indicators (mead barrels or drinking horns)
- [  ] Implement wood texture backgrounds
- [  ] Add subtle animations for buttons and cards

### Feature Enhancements
- [  ] **Notification System**
  - [  ] Fermentation milestone alerts
  - [  ] Customizable notification schedule
  - [  ] Batch completion notifications

- [  ] **Enhanced Recipe Management**
  - [  ] Save favorite YouTube recipes
  - [  ] Create and edit custom recipes
  - [  ] Recipe categories and tags
  - [  ] Recipe sharing functionality

- [  ] **User Preferences**
  - [  ] Temperature unit selection (°F/°C)
  - [  ] Gravity unit selection (SG/Plato)
  - [  ] Theme variations (Light/Dark Viking)
  - [  ] Font size options

- [  ] **Batch Tracking Improvements**
  - [  ] Graphing of gravity readings over time
  - [  ] Fermentation temperature tracking
  - [  ] Photo documentation of batches
  - [  ] Batch notes with formatting options

- [  ] **Export/Import Functionality**
  - [  ] Export batches as PDF
  - [  ] Share recipes via social media
  - [  ] Backup and restore data
  - [  ] Cloud synchronization

### Technical Improvements
- [  ] Implement caching for YouTube search results
- [  ] Add offline support for core functionality
- [  ] Optimize database queries
- [  ] Reduce app size and improve performance
- [  ] Add widget for tracking active batches
- [  ] Implement deep linking

## Viking Theme Elements to Maintain

Always maintain the established Viking color scheme:
- Background: Dark wood brown (#2C1810)
- Buttons: Light wood brown (#B08968)
- Accent: Soft gold (#DAA520)
- Hover/Active: Deep red (#8B0000)
- Text: Dark brown on light backgrounds, Parchment (#F5E6D3) on dark
- Font: Papyrus for Norse feel

Continue using Norse-inspired naming:
- "Mjöðr Calculator"
- "Sacred Measurements"
- "Wisdom of Odin"
- "Ancient Recipes"
- "Mead Hall"
- "Runes of Knowledge"

## Version History

### v1.0 (Current)
- Core ABV calculation with temperature correction
- YouTube recipe search integration
- Basic batch tracking system
- Viking-themed UI with custom navigation components
- Comprehensive test suite

### v1.1 (Planned)
- App icon and splash screen
- Bug fixes and performance improvements
- Play Store release

### v2.0 (Future)
- Enhanced visual elements
- Notification system
- Improved recipe management
- User preferences
- Advanced batch tracking

### v3.0 (Long-term)
- Community features
- Integration with brewing equipment
- Expanded mead knowledge base
- AR visualization of fermentation
