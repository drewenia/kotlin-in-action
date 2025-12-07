package ch02

/* Bir property accessor’ına custom bir implementasyonun nasıl sağlanabileceğine bakalım. Bunun yaygın kullanım
durumlarından biri, bir property’nin object içindeki diğer property’lerin doğrudan bir sonucu olmasıdır. Eğer width ve
height değerlerini saklayan bir Rectangle class’ın varsa, width ve height eşit olduğunda true olan bir isSquare
property’si sağlayabilirsin. Bu bir property olduğu için, ona erişildiğinde “anlık” olarak kontrol edebilir, erişim
sırasında hesaplayabilirsin; bu bilgiyi ayrı bir field olarak saklaman gerekmez. Bunun yerine, Rectangle’ın “kareliğini”
property her erişildiğinde hesaplayan bir custom getter sağlayabilirsin.
*/

class Rectangle222(val height : Int, val width : Int) {
    val isSquare : Boolean
        // Property getter declaration
        get(){
            return height == width
        }

    val isSquarev2 get() = height == width
}

/* Küme parantezleriyle tam söz dizimini kullanmak zorunda olmadığını unutma. Diğer herhangi bir function gibi,
getter’ı expression-body syntax'ı ile tanımlayabilir ve val isSquare get() = height == width şeklinde de yazabilirsin.
Gördüğün gibi, expression-body söz dizimi ayrıca property type’ını açıkça belirtmeyi de atlamana imkân tanır; bunun
yerine type’ı senin için compiler infer eder. Hangi söz dizimini seçersen seç, isSquare gibi bir property’nin
invocation’ı aynı kalır:
*/

fun main(){
    val rect = Rectangle222(11,22)
    println(rect.isSquarev2) // false
}

/* Bu property’ye Java’dan erişmen gerekirse, eskisi gibi isSquare method’unu çağırırsın. Custom bir getter ile bir
property declare etmenin mi yoksa class içinde bir function tanımlamanın (Kotlin’de buna member function veya method
denir) mı daha iyi olduğunu sorabilirsin. Her iki seçenek de benzerdir: implementasyon veya performans açısından hiçbir
fark yoktur; yalnızca okunabilirlik açısından farklılık gösterirler. Genel olarak, bir class’ın karakteristiğini
(property’sini) tanımlıyorsan onu bir property olarak declare etmelisin. Bir class’ın davranışını tanımlıyorsan bunun
yerine bir member function seçmelisin. */

