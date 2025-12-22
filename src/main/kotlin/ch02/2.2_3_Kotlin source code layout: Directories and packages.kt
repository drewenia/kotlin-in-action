package ch02

/* Programların daha karmaşık hale gelip daha fazla function, class ve diğer dil yapılarından oluşmaya başladıkça,
projenin sürdürülebilir ve gezilebilir kalması için kaynak kodunu nasıl organize edeceğini düşünmen kaçınılmaz hale
gelir. Kotlin projelerinin genellikle nasıl yapılandırıldığına bakalım. Kotlin, class’ları organize etmek için package
kavramını kullanır (Java’dan aşina olabileceğin bir yapıya benzer). Her Kotlin file’ı başlangıcında bir package
bildirimi içerebilir ve file içinde tanımlanan tüm declaration’lar (class, function ve property’ler) bu package içine
yerleştirilir.

Aşağıdaki code, package declaration ifadesinin söz dizimini gösteren bir source file örneğini göstermektedir.
*/

/*
package geometry.shapes // package declaration

class Rectangle223(val height : Int, val width : Int){
    val isSquare get() = height == width
}

fun createUnitSquare() : Rectangle223{
    return Rectangle223(11,11)
}
*/

/* Diğer file’larda tanımlanan declaration’lar aynı package içindeyse doğrudan kullanılabilir; farklı bir package
içindeyseler import edilmeleri gerekir. Bu işlem, file’ın başlangıcında, package yönergesinin hemen altında yer alan
import keyword’ü kullanılarak yapılır. Kotlin, class veya function import etme arasında bir ayrım yapmaz ve import
keyword’ünü kullanarak herhangi bir tür declaration’ı import etmeni sağlar. Eğer geometry.example package’ında bir demo
project yazıyorsan, geometry.shapes package’ındaki Rectangle class’ını ve createUnitSquare function’ını yalnızca
adlarıyla import ederek kullanabilirsin. */

/*
package geometry.example
import geometry.shapes.Rectangle
import geometry.shapes.createUnitSquare
fun main() {
    println(Rectangle(3, 4).isSquare)
    // false
    println(createUnitSquare().isSquare)
    // true
}
*/

/* Belirli bir package içinde tanımlanan tüm declaration’ları, package adının sonuna .* yazarak da import edebilirsin.
Bu star import’un (wildcard import olarak da adlandırılır) package içinde tanımlanan her şeyi görünür hâle getirdiğini
unutma—yalnızca class’ları değil, top-level function ve property’leri de kapsar. Explicit import yerine
import geometry.shapes.* yazmak da code’un doğru şekilde compile edilmesini sağlar. */

/* Java’da class’larını, package yapısıyla eşleşen bir file ve directory yapısına yerleştirirsin. Örneğin, shapes adlı
bir package’ın ve içinde birkaç class’ın varsa, her class’ı eşleşen bir adla ayrı bir file’a koyman ve bu file’ları
shapes adı verilen bir directory içinde saklaman gerekir. img.png, geometry package’ının ve alt package’larının Java’da
nasıl organize edilebileceğini gösterir. createUnitSquare function’ının RectangleUtil adlı ayrı bir file’da bulunduğunu
varsay
*/

/* Kotlin’de birden fazla class’ı aynı file içine koyabilir ve o file için istediğin herhangi bir adı seçebilirsin.
Kotlin ayrıca source file’ların disk üzerindeki yerleşimi konusunda herhangi bir kısıtlama getirmez; file’larını
organize etmek için istediğin directory yapısını kullanabilirsin. Örneğin, geometry.shapes package’ının tüm içeriğini
shapes.kt adlı file içinde tanımlayabilir ve bu file’ı ayrı bir shapes folder oluşturmak zorunda kalmadan geometry
folder’ına yerleştirebilirsin. img_1.png
*/

/* Ancak çoğu durumda, source file’ları package yapısına göre, Java’nın directory düzenini izleyerek directory’lere
ayırmak hâlâ iyi bir pratiktir. Bu yapıya sadık kalmak özellikle Kotlin’in Java ile birlikte kullanıldığı projelerde
önemlidir; çünkü bu sayede code’u aşamalı olarak migrate ederken beklenmedik durumlar oluşmasını engellersin. Ama
özellikle küçük class’lar söz konusu olduğunda (ve Kotlin’de class’lar çoğu zaman küçüktür), birden fazla class’ı aynı
file içine koymaktan çekinmemelisin. */
