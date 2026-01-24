@JvmInline
value class ValidateInput(val s : String)

fun save (v: ValidateInput) : Unit = TODO()

fun main() {
    val rawInput = "needs validating"
    // save(rawInput) // ValidatedInput ile String arasındaki type mismatch nedeniyle compile olmaz.
}