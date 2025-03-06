# Script to set up Android development environment variables
$ErrorActionPreference = "Stop"

Write-Host "Setting up Android development environment..." -ForegroundColor Green

# Define paths
$JAVA_HOME = "C:\Program Files\Eclipse Adoptium\jdk-17.0.14.7-hotspot"
$ANDROID_SDK = "$env:LOCALAPPDATA\Android\Sdk"
$ANDROID_STUDIO = "C:\Program Files\Android\Android Studio"

# Verify Java installation
if (-not (Test-Path $JAVA_HOME)) {
    Write-Host "Error: JDK not found at $JAVA_HOME" -ForegroundColor Red
    exit 1
}

# Verify Android SDK installation
if (-not (Test-Path $ANDROID_SDK)) {
    Write-Host "Note: Android SDK not found at default location. Will be created by Android Studio." -ForegroundColor Yellow
}

# Verify Android Studio installation
if (-not (Test-Path $ANDROID_STUDIO)) {
    Write-Host "Error: Android Studio not found at $ANDROID_STUDIO" -ForegroundColor Red
    exit 1
}

# Set environment variables
try {
    # Set JAVA_HOME
    [System.Environment]::SetEnvironmentVariable("JAVA_HOME", $JAVA_HOME, [System.EnvironmentVariableTarget]::User)
    Write-Host "Set JAVA_HOME to $JAVA_HOME" -ForegroundColor Green

    # Set ANDROID_HOME
    [System.Environment]::SetEnvironmentVariable("ANDROID_HOME", $ANDROID_SDK, [System.EnvironmentVariableTarget]::User)
    Write-Host "Set ANDROID_HOME to $ANDROID_SDK" -ForegroundColor Green

    # Update PATH
    $userPath = [System.Environment]::GetEnvironmentVariable("Path", [System.EnvironmentVariableTarget]::User)
    $pathsToAdd = @(
        "$JAVA_HOME\bin",
        "$ANDROID_SDK\tools",
        "$ANDROID_SDK\platform-tools",
        "$ANDROID_STUDIO\bin"
    )

    $newPaths = $pathsToAdd | Where-Object { $userPath -notlike "*$_*" }
    if ($newPaths) {
        $newPath = $userPath + ";" + ($newPaths -join ";")
        [System.Environment]::SetEnvironmentVariable("Path", $newPath, [System.EnvironmentVariableTarget]::User)
        Write-Host "Added to PATH:" -ForegroundColor Green
        $newPaths | ForEach-Object { Write-Host "  $_" -ForegroundColor Green }
    }

    Write-Host "`nEnvironment variables set successfully!" -ForegroundColor Green
    Write-Host "Please restart your terminal for the changes to take effect." -ForegroundColor Yellow

    # Verify Java version
    Write-Host "`nVerifying Java installation:" -ForegroundColor Cyan
    & "$JAVA_HOME\bin\java.exe" -version

} catch {
    Write-Host "Error: Failed to set environment variables: $_" -ForegroundColor Red
    exit 1
}

Write-Host "`nNext steps:" -ForegroundColor Cyan
Write-Host "1. Launch Android Studio and complete the setup wizard" -ForegroundColor White
Write-Host "2. Install Android SDK components when prompted" -ForegroundColor White
Write-Host "3. Open your Android project and start developing!" -ForegroundColor White
