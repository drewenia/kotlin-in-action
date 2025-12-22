package ch02

/* Bir for (x in y) loop’unu kullanmanın en yaygın senaryosunun bir collection üzerinde iteration yapmak olduğunu
belirtmiştik. Muhtemelen davranışına zaten aşinasındır — loop, input collection içindeki her element için çalışır.
Bu durumda, color’ların collection’ındaki her element’i sadece print edersin. Loop’un içinde, tek tek color’lara
for loop’ta kullanılan isim bu olduğu için color ile erişilebilir; aşağıdaki listede gösterildiği gibi. */

fun main() {
    val collection = listOf("red", "green", "blue")

    for (color in collection) {
        println("$color ") // red green blue
    }

    for (char in 'A'..'Z') {
        characterToBinaryRepresentation243(char)
    }
    printList243()
}

/* Bir map üzerinde nasıl iteration yapılır. Örnek olarak, karakterlerin binary representation’larını print eden küçük
bir programa bakacağız — bu da sana 1000100 1000101 1000011 1000001 1000110 gibi binary-encoded text’i elle çözmende
yardımcı olacak basit bir lookup table sağlar! Bu binary representation’ları bir map içinde saklayacaksın */

fun characterToBinaryRepresentation243(c: Char) {
    val binaryRepresentation = mutableMapOf<Char, String>()

    val binary = c.code.toString(2) // Converts ASCII code to binary
    binaryRepresentation[c] = binary

    for ((letter, binary) in binaryRepresentation) {
        println("$letter = $binary")
    }
}

fun characterToBinaryRepresentation243v2() {
    val binaryRepresentation = mutableMapOf<Char, String>()
    for (char in 'A'..'Z') {
        val binary = char.code.toString(2) // Converts ASCII code to binary
        binaryRepresentation[char] = binary
    }
    for ((letter, binary) in binaryRepresentation) {
        println("$letter : $binary")
    }
}

/* Output
// A = 1000001 D = 1000100
// B = 1000010 E = 1000101
// C = 1000011 F = 1000110
*/

/* for loop’un iteration yaptığın bir collection’ın element’ini (bu durumda, map içindeki key–value pair’lerin
collection’ı) unpack etmeni sağladığını gösterir. Unpack etmenin sonucunu iki ayrı variable’a saklarsın: letter key’i
alır, binary ise value’yu alır. Kullanılan bir diğer hoş trick, bir map’in key ile value’larını almak ve güncellemek
için kullanılan shorthand syntax’tır. Get ve put gibi function’ları çağırmak zorunda kalmak yerine, value okumak için
map[key] ve value set etmek için map[key] = value kullanabilirsin. Bu, Java-style binaryReps.put(char, binary)
kullanımını yapmak yerine, bununla eşdeğer fakat daha elegant olan binaryReps[char] = binary yazabileceğin anlamına
gelir. Aynı unpacking syntax’ını, current item’ın index’ini takip ederken bir collection üzerinde iteration yapmak için
kullanabilirsin. Bu, index’i saklamak için ayrı bir variable oluşturma ve onu elle increment etme gereksinimini ortadan
kaldırır. Bu durumda, element’leri respective index’leriyle birlikte withIndex function’ını kullanarak print ediyorsun.
*/

fun printList243() {
    val list = listOf("10", "11", "1001")
    for ((index, element) in list.withIndex()) {
        println("Index : $index, Element : $element")
    }
}

/* In keyword’ünü bir range ya da collection üzerinde iteration yapmak için nasıl kullanabileceğini gördün. Bunun
ötesinde, bir value’nun bir range ya da collection’a ait olup olmadığını kontrol etmek için de in kullanabilirsin. */