package com.ccsimenson.mjodr.data

import com.google.gson.*
import java.lang.reflect.Type
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Gson TypeAdapter for converting LocalDate objects to and from JSON
 */
class LocalDateAdapter : JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
    
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE
    
    override fun serialize(
        src: LocalDate,
        typeOfSrc: Type,
        context: JsonSerializationContext
    ): JsonElement {
        return JsonPrimitive(formatter.format(src))
    }
    
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): LocalDate {
        return LocalDate.parse(json.asString, formatter)
    }
}
