import java.time.LocalDate

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
    // Bu object, LocalDate element’leri üzerinde bir Iterator implement eder.
    object : Iterator<LocalDate> {
        // start -> The minimum value in the range.
        var current = start
        override fun next(): LocalDate {
            val thisDate = current

            // Mevcut tarihi bir yıl artırır.
            current = current.plusYears(1)

            // Pre increment edilmiş tarihi döndürür.
            return thisDate
        }

        // Tarihler için kullanılan compareTo convention’ına dikkat edin (current <= endInclusive)
        // endInclusive -> The maximum value in the range (inclusive)
        override fun hasNext(): Boolean = current <= endInclusive

    }

fun main() {
    val birthDay = LocalDate.of(1976, 11, 29)
    val today = LocalDate.now()

    // birthDay'den 1 gün çıkart -> range today'e kadar
    val monthsOff = birthDay.minusDays(1)..today

    for (month in monthsOff){
        println(month)
        // 1976-11-28
        // 1977-11-28
        // 1978-11-28
        // 1979-11-28
        // 1980-11-28
        // ...
    }
}

