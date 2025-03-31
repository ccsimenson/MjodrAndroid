# Mjöðr Development Roadmap

## Current Version (v1.0)

### Core Features
- [x] ABV Calculator with temperature correction
- [x] Traditional Recipe Search (YouTube integration)
- [x] Batch Management with fermentation tracking
- [x] Viking-themed UI with authentic Norse aesthetic
- [x] Historical Brewing Information
- [x] Data persistence with Room Database
- [x] Offline support

### Technical Stack
- [x] **UI**: Jetpack Compose with Material 3
- [x] **Architecture**: MVVM with Clean Architecture
- [x] **Dependency Injection**: Hilt
- [x] **Data Persistence**: Room Database
- [x] **Network**: Retrofit + OkHttp
- [x] **State Management**: ViewModel + StateFlow
- [x] **Navigation**: Jetpack Navigation Compose
- [x] **Testing**: JUnit + Espresso + Compose Testing

## Version 1.1 (Planned)

### Feature Enhancements
- [ ] Enhanced batch tracking with fermentation milestones
- [ ] Notification system for fermentation progress
- [ ] User preferences and settings
- [ ] Export/import functionality for recipes and batches
- [ ] Improved recipe management with favorites

### Visual Improvements
- [ ] Additional Norse-themed UI elements
- [ ] Animation effects for key interactions
- [ ] Improved accessibility support

### Technical Improvements
- [ ] Performance optimizations
- [ ] Better offline support
- [ ] Enhanced error handling

## Version 2.0 (Future)

### Major Features
- [ ] Advanced brewing calculations
- [ ] Social sharing capabilities
- [ ] Recipe collaboration
- [ ] Advanced batch analytics
- [ ] Cloud synchronization

### Visual Redesign
- [ ] Complete UI overhaul with more Norse elements
- [ ] Dynamic animations and transitions
- [ ] Improved dark mode support

### Technical Architecture
- [ ] Complete codebase refactoring
- [ ] Enhanced testing infrastructure
- [ ] Improved build system
- [ ] Better documentation

## Viking Theme Requirements

All versions must maintain the established Viking theme:

- **Color Scheme**:
  - Background: Dark wood brown (#2C1810)
  - Buttons: Light wood brown (#B08968)
  - Accent: Soft gold (#DAA520)
  - Hover/Active: Deep red (#8B0000)
  - Text: Dark brown on light backgrounds, Parchment (#F5E6D3) on dark
  - Font: Papyrus for Norse feel

- **Naming Conventions**:
  - All features must have Norse-inspired names
  - UI components should follow Viking aesthetic
  - Documentation should maintain the theme

## Testing Requirements

- All new features must include unit tests
- UI components should have corresponding Compose tests
- Instrumentation tests should cover critical user flows
- Performance tests for major operations
- Accessibility tests for all screens

## Release Process

1. Feature development in feature branches
2. Comprehensive testing
3. Code review
4. Merge to develop branch
5. Release candidate testing
6. Merge to main branch
7. Create release tag
8. Deploy to Play Store
