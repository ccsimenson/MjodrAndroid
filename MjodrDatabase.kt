package com.ccsimenson.mjodr.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ccsimenson.mjodr.data.dao.MeadBatchDao
import com.ccsimenson.mjodr.data.dao.MeasurementDao
import com.ccsimenson.mjodr.data.model.MeadBatch
import com.ccsimenson.mjodr.data.model.GravityMeasurement
import com.ccsimenson.mjodr.data.model.Recipe
import com.ccsimenson.mjodr.data.model.YoutubeVideo
import com.ccsimenson.mjodr.util.Converters

@Database(
    entities = [
        MeadBatch::class,
        GravityMeasurement::class,
        Recipe::class,
        YoutubeVideo::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class MjodrDatabase : RoomDatabase() {
    abstract fun meadBatchDao(): MeadBatchDao
    abstract fun measurementDao(): MeasurementDao

    companion object {
        @Volatile
        private var INSTANCE: MjodrDatabase? = null

        fun getDatabase(context: Context): MjodrDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MjodrDatabase::class.java,
                    "mjodr_database"
                )
                .fallbackToDestructiveMigration()
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}

package com.ccsimenson.mjodr.util

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.ZoneOffset

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): LocalDateTime? {
        return value?.let { LocalDateTime.ofEpochSecond(it, 0, ZoneOffset.UTC) }
    }

    @TypeConverter
    fun dateToTimestamp(date: LocalDateTime?): Long? {
        return date?.toEpochSecond(ZoneOffset.UTC)
    }

    @TypeConverter
    fun fromStringList(value: String?): List<String> {
        return value?.split(",")?.map { it.trim() } ?: emptyList()
    }

    @TypeConverter
    fun toStringList(list: List<String>): String {
        return list.joinToString(",")
    }
}

