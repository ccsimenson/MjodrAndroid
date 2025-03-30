#!/bin/bash

echo "# Mjöðr Project Structure Verification"

# Define color codes for better visibility
GREEN='\033[0;32m'
RED='\033[0;31m'
NC='\033[0m'

# Set project root to new location
PROJECT_ROOT=~/MjodrAndroid_new

# Function to check file existence
check_file() {
    if [ -f "$1" ]; then
        echo -e "${GREEN}✓${NC} $2"
    else
        echo -e "${RED}✗${NC} Missing: $2"
    fi
}

echo -e "\n## Core Files"
check_file "$PROJECT_ROOT/app/src/main/AndroidManifest.xml" "AndroidManifest.xml"
check_file "$PROJECT_ROOT/build.gradle.kts" "build.gradle.kts (root)"
check_file "$PROJECT_ROOT/app/build.gradle.kts" "build.gradle.kts (app)"
check_file "$PROJECT_ROOT/settings.gradle.kts" "settings.gradle.kts"
check_file "$PROJECT_ROOT/local.properties" "local.properties"

echo -e "\n## UI Components"
check_file "$PROJECT_ROOT/app/src/main/java/com/ccsimenson/mjodr/MainActivity.kt" "MainActivity.kt"
check_file "$PROJECT_ROOT/app/src/main/java/com/ccsimenson/mjodr/ui/screens/AbvCalculatorScreen.kt" "AbvCalculatorScreen.kt"
check_file "$PROJECT_ROOT/app/src/main/java/com/ccsimenson/mjodr/ui/screens/RecipesScreen.kt" "RecipesScreen.kt"
check_file "$PROJECT_ROOT/app/src/main/java/com/ccsimenson/mjodr/ui/screens/MeadHallScreen.kt" "MeadHallScreen.kt"
check_file "$PROJECT_ROOT/app/src/main/java/com/ccsimenson/mjodr/ui/screens/HelpScreen.kt" "HelpScreen.kt"

echo -e "\n## Data Models"
check_file "$PROJECT_ROOT/app/src/main/java/com/ccsimenson/mjodr/data/model/MeadBatch.kt" "MeadBatch.kt"
check_file "$PROJECT_ROOT/app/src/main/java/com/ccsimenson/mjodr/data/model/GravityMeasurement.kt" "GravityMeasurement.kt"
check_file "$PROJECT_ROOT/app/src/main/java/com/ccsimenson/mjodr/data/model/BatchStatus.kt" "BatchStatus.kt"
check_file "$PROJECT_ROOT/app/src/main/java/com/ccsimenson/mjodr/data/model/Recipe.kt" "Recipe.kt"
check_file "$PROJECT_ROOT/app/src/main/java/com/ccsimenson/mjodr/data/model/YoutubeVideo.kt" "YoutubeVideo.kt"

echo -e "\n## Database Components"
check_file "$PROJECT_ROOT/app/src/main/java/com/ccsimenson/mjodr/data/dao/MeadBatchDao.kt" "MeadBatchDao.kt"
check_file "$PROJECT_ROOT/app/src/main/java/com/ccsimenson/mjodr/data/dao/MeasurementDao.kt" "MeasurementDao.kt"
check_file "$PROJECT_ROOT/app/src/main/java/com/ccsimenson/mjodr/data/MjodrDatabase.kt" "MjodrDatabase.kt"

echo -e "\n## UI Theme"
check_file "$PROJECT_ROOT/app/src/main/java/com/ccsimenson/mjodr/ui/theme/Color.kt" "Color.kt"
check_file "$PROJECT_ROOT/app/src/main/java/com/ccsimenson/mjodr/ui/theme/Theme.kt" "Theme.kt"
check_file "$PROJECT_ROOT/app/src/main/java/com/ccsimenson/mjodr/ui/theme/Type.kt" "Type.kt"

echo -e "\n## Resources"
check_file "$PROJECT_ROOT/app/src/main/res/layout/activity_main.xml" "activity_main.xml"
check_file "$PROJECT_ROOT/app/src/main/res/values/colors.xml" "colors.xml"
check_file "$PROJECT_ROOT/app/src/main/res/values/strings.xml" "strings.xml"
check_file "$PROJECT_ROOT/app/src/main/res/values/themes.xml" "themes.xml"
check_file "$PROJECT_ROOT/app/src/main/res/navigation/nav_graph.xml" "nav_graph.xml"

echo -e "\n## Directory Structure"
echo "Checking complete project structure in $PROJECT_ROOT..."
if [ -d "$PROJECT_ROOT" ]; then
    tree -L 6 "$PROJECT_ROOT"
else
    echo -e "${RED}✗${NC} Directory $PROJECT_ROOT does not exist"
fi
