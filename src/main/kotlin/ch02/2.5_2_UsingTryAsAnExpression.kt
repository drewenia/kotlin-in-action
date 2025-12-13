package ch02

import java.io.BufferedReader
import java.io.StringReader

/* Şu ana kadar try construct’ünün yalnızca bir statement olarak kullanıldığını gördün. Ancak try bir expression olduğu
için (if ve when gibi), bundan yararlanmak üzere örneğini biraz değiştirip try expression’ının value’sunu bir variable’a
assign edebilirsin. Kısalık adına, finally bölümünü kaldıralım (yalnızca bunun nasıl çalıştığını zaten gördüğün
için—stream’leri kapatmamak için bunu bir bahane olarak kullanma!) ve file’dan okuduğun sayıyı print etmek için biraz
code ekleyelim. */

fun readNumber252(reader : BufferedReader){
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e : NumberFormatException){
        return
    }
    println(number)
}

fun main() {
    val reader = BufferedReader(StringReader("not a number"))
    readNumber252(reader) // Hiçbir şey print edilmez.
    val reader2 = BufferedReader(StringReader("not a number"))
    readNumber252v2(reader2) // null
}

/* if’ten farklı olarak, statement body’yi her zaman curly brace’ler içine alman gerektiğini belirtmekte fayda var.
Diğer statement’larda olduğu gibi, body birden fazla expression içeriyorsa, try expression’ının tamamının value’su son
expression’ın value’sudur. Bu örnekte catch block’una bir return statement konur; bu nedenle function’ın execution’ı
catch block’undan sonra devam etmez. Execution’a devam etmek istiyorsan, catch clause’unun da bir value’su olması
gerekir; bu da içindeki son expression’ın value’su olacaktır. Bunun nasıl çalıştığına bakalım. */

// catch içinde bir value döndürme
fun readNumber252v2(reader : BufferedReader){
    // Exception oluşmadığında bu value kullanılır.
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e : NumberFormatException){
        // Exception durumunda null value kullanılır.
        null
    }
    println(number)
}

/* Bir try code block’unun execution’ı normal şekilde gerçekleşirse, block içindeki son expression result olur. Bir
exception catch edilirse, ilgili catch block’undaki son expression result olur. Yukarıda ki code'da, bir
NumberFormatException catch edilirse result value null’dır. Try’ı bir expression olarak kullanmak, ek intermediate
variable’lar tanıtmaktan kaçınarak code’unu biraz daha concise hale getirmeni sağlar ve fallback value’ları kolayca
assign etmene ya da enclosing function’dan doğrudan return etmene olanak tanır. */

