package ch02

/* Kotlin’de exception handling, Java’da ve diğer birçok language’da yapılış şekline benzerdir. Bir function normal
şekilde tamamlanabilir ya da bir error oluşursa bir exception throw edebilir. Function’ı call eden taraf bu exception’ı
catch edip process edebilir; eğer etmezse, exception stack boyunca daha yukarıya yeniden throw edilir. Bir exception’ı
throw keyword’ünü kullanarak throw edersin — bu durumda, calling function’ın geçersiz bir percentage value sağladığını
belirtmek için. */

fun main() {
    println(checkPercentage25(41))
    println(checkPercentage25v2(11))
}

fun checkPercentage25(percentage: Int) {
    if (percentage !in 0..100)
        throw IllegalArgumentException("A percentage value must be between 0 and 100: $percentage")
}

/* Bu, Kotlin’in new keyword’üne sahip olmadığını kendine hatırlatmak için iyi bir zamandır. Bir exception instance’ı
oluşturmak farklı değildir. Kotlin’de throw construct’ü bir expression’dır ve diğer expression’ların bir parçası olarak
kullanılabilir. */

fun checkPercentage25v2(percentage: Int): Int {
    val number =
        if (percentage in 1..100)
            percentage
        else
            throw IllegalArgumentException("A percentage value must be between 0 and 100: $percentage")
    return number
}