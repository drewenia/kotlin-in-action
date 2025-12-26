package ch02


/* Bir önceki 2.3_4 bölümündeki kodun biraz verimsiz olduğunu fark etmiş olabilirsin. Bu function’ı her çağırdığında,
yalnızca iki verilen rengin diğer iki renkle eşleşip eşleşmediğini kontrol etmek için kullanılan birkaç Set instance’ı
oluşturur. Normalde bu bir sorun değildir, ancak function sık çağrılıyorsa, garbage collector tarafından temizlenmesi
gereken çok sayıda kısa ömürlü object oluşturmayı önlemek için code’u farklı bir şekilde yeniden yazmaya değer. Bunu,
aşağıda gösterildiği gibi, when expression’ını bir argüman olmadan kullanarak yapabilirsin. Code daha az okunabilirdir,
ancak daha iyi performans elde etmek için çoğu zaman ödemen gereken bedel budur. */

/*fun mixOptimized234(c1: Color231v2, c2: Color231v2) {
    when {
        (c1 == RED && c2 == YELLOW) ||
                (c1 == YELLOW && c2 == RED) ->
            ORANGE

        (c1 == YELLOW && c2 == BLUE) ||
                (c1 == BLUE && c2 == YELLOW) ->
            GREEN

        (c1 == BLUE && c2 == VIOLET) ||
                (c1 == VIOLET && c2 == BLUE) ->
            INDIGO
        else -> throw Exception("Dirty color")
    }
}

fun main() {
    mixOptimized234(RED,GREEN) // Exception -> Dirty color
}*/

/* When expression’ı için bir argüman verilmezse, branch koşulu herhangi bir Boolean expression olur. mixOptimized
function’ı, mix’in daha önce yaptığıyla aynı şeyi yapar. Avantajı, ekstra object oluşturmamasıdır; ancak bunun bedeli
daha zor okunmasıdır. Şimdi devam edelim ve smart cast’lerin devreye girdiği when yapısı örneklerine bakalım. */