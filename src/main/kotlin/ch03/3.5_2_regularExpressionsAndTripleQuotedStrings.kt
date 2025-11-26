package ch03

/* İki farklı implementation içeren başka bir örneğe bakalım: ilki String üzerindeki extension’ları kullanacak, ikincisi
ise regular expression’larla çalışacak. Göreviniz, bir file’ın tam path name’ini bileşenlerine ayırmaktır: bir
directory, bir filename ve bir extension. Kotlin standard library, verilen delimiter’ın ilk (veya son) görülme
durumundan önceki (veya sonraki) substring’i almak için function’lar içerir.
*/

// "/Users/yole/kotlin-book/chapter.adoc"

// directory before last slash -> /Users/yole/kotlin-book/
// filename -> chapter
// extension -> adoc

const val path = "/Users/yole/kotlin-book/chapter.adoc"

fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    println(directory) // /Users/yole/kotlin-book

    val fullName = path.substringAfterLast("/")
    println(fullName) // chapter.adoc

    val fileName = fullName.substringBeforeLast(".")
    println(fileName) // chapter

    val extension = fullName.substringAfterLast(".")
    println(extension) // adoc
}

/* Eğer regular expression kullanmak isterseniz, Kotlin standard library yardımcı olabilir. Aşağıdaki code, aynı görevin
regular expression kullanılarak nasıl yapılabileceğini gösterir.*/

fun parsePathRegex(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("Dir : $directory, name : $filename, extension : $extension")
    }
}

/* Yukarıda ki örnekte regular expression, triple-quoted bir string içinde yazılmıştır. Böyle bir string’de backslash
dahil hiçbir karakteri escape etmeniz gerekmez; dolayısıyla literal bir dot ile eşleşen bir regular expression’ı, normal
bir string literalinde yazacağınız \. yerine . şeklinde yazabilirsiniz. Bu regular expression, bir path’i slash ve dot
ile ayrılmış üç gruba böler. Pattern . başlangıçtan itibaren herhangi bir karakterle eşleşir, dolayısıyla ilk grup (.+)
son slash’ten önceki substring’i içerir. Bu substring, “herhangi bir karakter” pattern’ı ile eşleştikleri için önceki
tüm slash’leri de içerir. Benzer şekilde, ikinci grup son dot’tan önceki (ve son slash’ten sonraki) substring’i içerir
ve üçüncü grup kalan kısmı içerir. parsePathRegex function’ının implementation’ını tartışalım. Bir regular expression
oluşturur ve onu input path ile eşleştirirsiniz. Eşleşme başarılı olursa (sonuç null değilse), destructured
property’sinin value’sunu ilgili variable’lara assign edersiniz. Bu, iki variable’ı bir Pair ile initialize ederken
kullandığınız syntax’ın aynısıdır*/

fun main() {
    parsePath(path)
    parsePathRegex(path)
}