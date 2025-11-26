package ch03

/* Triple-quoted string’lerin amacı sadece karakterleri escape etmekten kaçınmak değildir. Böyle bir string literal,
satır sonları da dahil olmak üzere herhangi bir karakter içerebilir. Bu, programlarınıza satır sonları içeren metinleri
kolayca gömmenin bir yolunu sağlar.*/

val kotlinLogo =
    """
| //
|//
|/ \
""".trimIndent()

fun main() {
    println(kotlinLogo)
}