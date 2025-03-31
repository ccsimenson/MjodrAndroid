# Verify Mjöðr Android Project Structure

Write-Host "`nVerifying project structure...`n" -ForegroundColor Cyan

# Define required files and directories
$requiredFiles = @(
    "build.gradle.kts",
    "settings.gradle.kts",
    "README.md",
    "LICENSE",
    "CHANGELOG.md",
    "CONTRIBUTING.md",
    "ROADMAP.md",
    "TESTING.md",
    "local.properties",
    ".gitignore",
    ".gradle",
    "gradle",
    "gradlew",
    "gradlew.bat"
)

$appRequiredFiles = @(
    "build.gradle.kts",
    "proguard-rules.pro",
    "keystore.properties",
    "src/main/AndroidManifest.xml",
    "src/main/java",
    "src/main/res",
    "src/androidTest",
    "src/test"
)

# Check root directory
Write-Host "Checking root directory files..." -ForegroundColor Yellow
foreach ($file in $requiredFiles) {
    if (Test-Path -Path $file) {
        Write-Host "✓ $file" -ForegroundColor Green
    } else {
        Write-Host "✗ $file (missing)" -ForegroundColor Red
    }
}

# Check app directory
Write-Host "`nChecking app directory files..." -ForegroundColor Yellow
foreach ($file in $appRequiredFiles) {
    $fullPath = Join-Path -Path "app" -ChildPath $file
    if (Test-Path -Path $fullPath) {
        Write-Host "✓ $file" -ForegroundColor Green
    } else {
        Write-Host "✗ $file (missing)" -ForegroundColor Red
    }
}

# Check Android SDK and Java paths
Write-Host "`nVerifying development environment..." -ForegroundColor Yellow

# Check SDK path
$sdkPath = (Get-Content -Path local.properties | Where-Object { $_ -like "sdk.dir=*" } | ForEach-Object { $_.Split('=')[1] }).Trim()
if (Test-Path -Path $sdkPath) {
    Write-Host "✓ Android SDK found at $sdkPath" -ForegroundColor Green
} else {
    Write-Host "✗ Android SDK not found at $sdkPath" -ForegroundColor Red
}

# Check Java path
$javaPath = (Get-Content -Path local.properties | Where-Object { $_ -like "java.home=*" } | ForEach-Object { $_.Split('=')[1] }).Trim()
if (Test-Path -Path $javaPath) {
    Write-Host "✓ Java found at $javaPath" -ForegroundColor Green
} else {
    Write-Host "✗ Java not found at $javaPath" -ForegroundColor Red
}

# Check Gradle wrapper
Write-Host "`nChecking Gradle wrapper..." -ForegroundColor Yellow
$gradleWrapperPath = Join-Path -Path "gradle" -ChildPath "wrapper"
if (Test-Path -Path $gradleWrapperPath) {
    $gradleWrapperFiles = Get-ChildItem -Path $gradleWrapperPath -File
    if ($gradleWrapperFiles.Count -eq 2) {
        Write-Host "✓ Gradle wrapper files found" -ForegroundColor Green
    } else {
        Write-Host "✗ Gradle wrapper files missing" -ForegroundColor Red
    }
} else {
    Write-Host "✗ Gradle wrapper directory missing" -ForegroundColor Red
}

# Check build configuration
Write-Host "`nChecking build configuration..." -ForegroundColor Yellow
$buildConfig = Get-Content -Path "app/build.gradle.kts" -Raw
if ($buildConfig -match "isMinifyEnabled = true") {
    Write-Host "✓ ProGuard enabled for release builds" -ForegroundColor Green
} else {
    Write-Host "✗ ProGuard not enabled for release builds" -ForegroundColor Red
}

# Check signing configuration
$signingConfigPattern = "signingConfig = signingConfigs.getByName\(`"release`"\)"
if ($buildConfig -match $signingConfigPattern) {
    Write-Host "✓ Signing configuration set for release builds" -ForegroundColor Green
} else {
    Write-Host "✗ Signing configuration not set for release builds" -ForegroundColor Red
}

Write-Host "`nVerification complete!" -ForegroundColor Cyan
