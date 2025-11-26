package ch03

/* Kotlin, Java ile tamamen aynı regular expression syntax’ını kullanır. Buradaki pattern bir dot (wildcard değil,
literal karakter kastettiğimizi belirtmek için escape edilmiştir) veya dash ile eşleşir. Regular expression’larla
çalışmaya yönelik API’ler de standart Java library API’lerine benzer, ancak daha idiomatiktir. Örneğin, Kotlin’de bir
string’i regular expression’a dönüştürmek için toRegex adlı bir extension function kullanırsınız. Fakat bu kadar basit
bir durumda regular expression kullanmanıza gerek yoktur. */

fun main(){
    val string = "12.345-6.A"
    val regex = "\\.|-".toRegex()
    println(string.split(regex)) // [12, 345, 6, A]
    println(mainv2()) // [12, 345, 6, A]
}

/* Kotlin’deki split extension function’ın diğer overload’ı, plain-text string olarak herhangi bir sayıda delimiter
alır. Bu method, yalnızca tek bir character’ı delimiter olarak alabilen benzer Java method’unun yerini alır.*/
fun mainv2(){
    println("12.345-6.A".split(".","-"))
}