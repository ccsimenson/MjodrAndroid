# Keep our main application class
-keep public class com.ccsimenson.mjodr.** { *; }

# Keep our data classes
-keepclassmembers class * extends androidx.room.Entity {
    private <fields>;
}

# Keep our ViewModel classes
-keepclassmembers class * extends androidx.lifecycle.ViewModel {
    private <fields>;
}

# Keep our Compose components
-keepclassmembers class * extends androidx.compose.runtime.Composable {
    private <fields>;
}

# Keep our navigation destinations
-keepclassmembers class * extends androidx.navigation.NavDestination {
    private <fields>;
}

# Keep our repository classes
-keepclassmembers class * extends androidx.datastore.DataStore {
    private <fields>;
}

# Keep our YouTube API classes
-keepclassmembers class * extends retrofit2.Call {
    private <fields>;
}

# Keep our MPAndroidChart classes
-keep class com.github.mikephil.charting.** { *; }
-dontwarn com.github.mikephil.charting.**

# Keep our Coil image loading classes
-keep class io.coil.** { *; }
-dontwarn io.coil.**

# Keep our DataStore classes
-keep class androidx.datastore.** { *; }
-dontwarn androidx.datastore.**

# Keep our ViewModel factories
-keepclassmembers class * implements androidx.lifecycle.ViewModelProvider.Factory {
    public <methods>;
}

# Keep our Room database classes
-keep class * extends androidx.room.Database {
    public <fields>;
}

# Keep our Room DAO classes
-keep class * extends androidx.room.Dao {
    public <fields>;
}

# Keep our Room entity classes
-keep class * extends androidx.room.Entity {
    public <fields>;
}

# Keep our Room converter classes
-keep class * extends androidx.room.TypeConverter {
    public <fields>;
}

# Keep our Room migration classes
-keep class * extends androidx.room.migration.Migration {
    public <fields>;
}

# Keep our Room database configuration classes
-keep class * extends androidx.room.RoomDatabase {
    public <fields>;
}

# Keep our Room database builder classes
-keep class * extends androidx.room.RoomDatabase.Builder {
    public <fields>;
}

# Keep our Room database query classes
-keep class * extends androidx.room.Query {
    public <fields>;
}

# Keep our Room database transaction classes
-keep class * extends androidx.room.Transaction {
    public <fields>;
}

# Keep our Room database type converter classes
-keep class * extends androidx.room.TypeConverter {
    public <fields>;
}

# Keep our Room database migration classes
-keep class * extends androidx.room.migration.Migration {
    public <fields>;
}

# Keep our Room database configuration classes
-keep class * extends androidx.room.RoomDatabase {
    public <fields>;
}

# Keep our Room database builder classes
-keep class * extends androidx.room.RoomDatabase.Builder {
    public <fields>;
}

# Keep our Room database query classes
-keep class * extends androidx.room.Query {
    public <fields>;
}

# Keep our Room database transaction classes
-keep class * extends androidx.room.Transaction {
    public <fields>;
}

# Keep our Room database type converter classes
-keep class * extends androidx.room.TypeConverter {
    public <fields>;
}

# Keep our Room database migration classes
-keep class * extends androidx.room.migration.Migration {
    public <fields>;
}

# Keep our Room database configuration classes
-keep class * extends androidx.room.RoomDatabase {
    public <fields>;
}

# Keep our Room database builder classes
-keep class * extends androidx.room.RoomDatabase.Builder {
    public <fields>;
}

# Keep our Room database query classes
-keep class * extends androidx.room.Query {
    public <fields>;
}

# Keep our Room database transaction classes
-keep class * extends androidx.room.Transaction {
    public <fields>;
}

# Keep our Room database type converter classes
-keep class * extends androidx.room.TypeConverter {
    public <fields>;
}

# Keep our Room database migration classes
-keep class * extends androidx.room.migration.Migration {
    public <fields>;
}

# Keep our Room database configuration classes
-keep class * extends androidx.room.RoomDatabase {
    public <fields>;
}

# Keep our Room database builder classes
-keep class * extends androidx.room.RoomDatabase.Builder {
    public <fields>;
}

# Keep our Room database query classes
-keep class * extends androidx.room.Query {
    public <fields>;
}

# Keep our Room database transaction classes
-keep class * extends androidx.room.Transaction {
    public <fields>;
}

# Keep our Room database type converter classes
-keep class * extends androidx.room.TypeConverter {
    public <fields>;
}

# Keep our Room database migration classes
-keep class * extends androidx.room.migration.Migration {
    public <fields>;
}

# Keep our Room database configuration classes
-keep class * extends androidx.room.RoomDatabase {
    public <fields>;
}

# Keep our Room database builder classes
-keep class * extends androidx.room.RoomDatabase.Builder {
    public <fields>;
}

# Keep our Room database query classes
-keep class * extends androidx.room.Query {
    public <fields>;
}

# Keep our Room database transaction classes
-keep class * extends androidx.room.Transaction {
    public <fields>;
}

# Keep our Room database type converter classes
-keep class * extends androidx.room.TypeConverter {
    public <fields>;
}

# Keep our Room database migration classes
-keep class * extends androidx.room.migration.Migration {
    public <fields>;
}

# Keep our Room database configuration classes
-keep class * extends androidx.room.RoomDatabase {
    public <fields>;
}

# Keep our Room database builder classes
-keep class * extends androidx.room.RoomDatabase.Builder {
    public <fields>;
}

# Keep our Room database query classes
-keep class * extends androidx.room.Query {
    public <fields>;
}

# Keep our Room database transaction classes
-keep class * extends androidx.room.Transaction {
    public <fields>;
}

# Keep our Room database type converter classes
-keep class * extends androidx.room.TypeConverter {
    public <fields