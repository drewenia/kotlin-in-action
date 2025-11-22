package ch02.tryCatchFinally

import java.io.BufferedReader
import java.io.StringReader

/*
    Şimdiye kadar try yapısını yalnızca bir statement olarak gördünüz. Ancak try bir expression olduğundan
    (if ve when gibi), örneğinizi biraz değiştirerek try expression’ının değerini bir variable’a assign edebilirsiniz.
    Belirtmek gerekir ki, if’in aksine, statement body’yi her zaman süslü parantez içine almanız gerekir. Diğer
    statement’larda olduğu gibi, eğer body birden fazla expression içeriyorsa, try expression’ının tamamının değeri
    son expression’ın değeri olur. Bu örnek catch bloğunda bir return statement koyar, bu nedenle fonksiyonun
    yürütülmesi catch bloğundan sonra devam etmez. Eğer yürütmenin devam etmesini istiyorsanız, catch clause’un da
    bir value’a sahip olması gerekir; bu, içindeki son expression’ın değeri olacaktır. Bunun örneği için bir alttaki
    metoda bakalım
*/
fun readNum(reader : BufferedReader){
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException){
        return
    }
}

// Returning a value in catch
fun readNumv2(reader : BufferedReader){
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException){
        null
    }
    println(number)
}

fun main() {
    val reader = BufferedReader(StringReader("not a number"))
    println(readNum(reader)) // nothing is printed
    println(readNumv2(reader)) // null (exception durumunda null value kullanilir)
}