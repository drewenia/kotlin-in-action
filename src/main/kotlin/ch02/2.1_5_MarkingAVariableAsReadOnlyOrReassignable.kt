package ch02

/* Bir variable’a ne zaman yeni bir value atanabileceğini kontrol edebilmek için Kotlin size iki keyword sunar:
val ve var.

**val** (value’dan gelir), read-only bir referans declare eder. val ile declare edilen bir variable yalnızca bir kez
assign edilebilir. Initialize edildikten sonra ona farklı bir value yeniden assign edilemez. (Karşılaştırma olarak,
Java’da bu final modifier ile ifade edilir.)

**var** (variable’dan gelir), yeniden assign edilebilir bir referans declare eder. Böyle bir variable’a, initialize
edildikten sonra bile başka value’lar assign edebilirsiniz. (Bu davranış Java’daki normal, final olmayan variable’lara
benzer.)

Bir **val** variable, tanımlandığı block’un çalışması sırasında **tam olarak bir kez** initialize edilmelidir. Ancak,
compiler’ın yalnızca bir initialization statement’ın çalışacağını garanti edebildiği sürece, bu initialization’ı bazı
koşullara bağlı olarak farklı value’larla yapabilirsiniz. Kendinizi, **result** adında bir variable’ın value’sunu,
başka bir fonksiyonun (örneğin **canPerformOperation**) döndürdüğü değere göre assign etmek istediğiniz bir durumda
bulabilirsiniz. Compiler, iki olası assignment’tan tam olarak birinin çalışacağını anlayacak kadar akıllıdır; bu nedenle
**result**’ı yine de **val** anahtar kelimesiyle read-only bir referans olarak specify edebilirsiniz:
*/

fun canPerformOperation215(): Boolean {
    return true
}

fun main() {
    val result: String
    val result2: String = if (canPerformOperation215()) "Success" else "Can't perform operation"
    if (canPerformOperation215()) {
        result = "Success"
    } else {
        result = "Can't perform operation"
    }
    println(result)
    println(result2)

    /* Bir **val** referansın kendisi read only’dir ve bir kez assign edildikten sonra değiştirilemez; ancak point
    ettiği object mutable olabilir. Örneğin, read-only bir referans tarafından point edilen mutable bir listeye bir
    element eklemek tamamen kabul edilebilir: */
    val languages = mutableListOf("Java")
    languages.add("Kotlin")
    println(languages) // [Java, Kotlin]

    /* **var** keyword'u bir variable’ın value’sunu değiştirmeye izin verse de, variable’ın type’ı sabittir. Örneğin,
    programın ortasında **answer** variable’ının bir integer yerine bir string saklaması gerektiğine karar verirseniz,
    bir compile error ile karşılaşırsınız: */
    var answer = 42
    // answer = "no answer" // error type mismatch

}