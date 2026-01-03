fun main() {
    val simpleLambda : (String) -> Unit = {println(it)}

    // 1. Durum: Otomatik Dönüşüm (Senin yaptığın)
    // Derleyici "arka planda" SAM Constructor kullanır.
    consumeHello(simpleLambda) // Hello

    // 2. Durum: Manuel (Explicit) Dönüşüm
    val explicit = StringConsumer(simpleLambda)
    consumeHello(explicit) // Hello
}

fun interface StringConsumer {
    fun consume(s: String)
}

fun consumeHello(s: StringConsumer) {
    s.consume("Hello")
}

fun consumeHelloFunctional(t: (String) -> Unit) {
    t("Hello")
}

