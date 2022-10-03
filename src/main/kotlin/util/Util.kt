package util

fun toIntOrThrowException(value: String): Int =
    value.toIntOrNull()?.let { value.toInt() }
        ?: throw IllegalArgumentException("$value ist keine Zahl!")