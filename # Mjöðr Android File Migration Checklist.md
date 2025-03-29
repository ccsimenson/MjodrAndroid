# Mjöðr Android File Migration Checklist

## Core Files
- [X] AndroidManifest.xml
- [X] build.gradle.kts (root)
- [X] build.gradle.kts (app)
- [X] settings.gradle.kts
- [X] local.properties
- [X] gradle/wrapper/*

## Source Files (/app/src/main/java/com/ccsimenson/mjodr/)

### UI Components
- [X] MainActivity.kt
- [X] AbvCalculatorScreen.kt
- [X] RecipesScreen.kt
- [X] MeadHallScreen.kt
- [ ] HelpScreen.kt

### Data Models
- [ ] data/model/MeadBatch.kt
- [ ] data/model/GravityMeasurement.kt
- [ ] data/model/BatchStatus.kt
- [ ] data/model/Recipe.kt
- [ ] data/model/YoutubeVideo.kt

### Database
- [ ] data/dao/MeadBatchDao.kt
- [ ] data/dao/MeasurementDao.kt
- [ ] data/MjodrDatabase.kt

### UI Theme
- [X] ui/theme/Color.kt
- [X] ui/theme/Theme.kt
- [X] ui/theme/Type.kt

### Resources (/app/src/main/res/)
- [ ] layout/activity_main.xml
- [X] values/colors.xml
- [X] values/strings.xml
- [X] values/themes.xml
- [X] drawable/* (Viking-themed assets)
- [ ] navigation/nav_graph.xml

## Project Structure
```
MjodrAndroid/
├── app/
│   ├── build.gradle.kts
│   └── src/
│       └── main/
│           ├── java/com/ccsimenson/mjodr/
│           │   ├── data/
│           │   │   ├── dao/
│           │   │   ├── model/
│           │   │   └── MjodrDatabase.kt
│           │   ├── ui/
│           │   │   ├── screens/
│           │   │   └── theme/
│           │   └── util/
│           ├── res/
│           │   ├── layout/
│           │   ├── values/
│           │   ├── drawable/
│           │   └── navigation/
│           └── AndroidManifest.xml
├── build.gradle.kts
├── settings.gradle.kts
└── local.properties
```

## Migration Commands
```bash
# Create directory structure
mkdir -p ~/MjodrAndroid/app/src/main/java/com/ccsimenson/mjodr/{data/{dao,model},ui/{screens,theme},util}
mkdir -p ~/MjodrAndroid/app/src/main/res/{layout,values,drawable,navigation}

# Check each file exists in source location
# Move files to new location maintaining structure
# Verify files after move
```