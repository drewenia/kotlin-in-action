import kotlin.reflect.KClass

interface FieldValidator<in T> {
    fun validate(input: T): Boolean
}

object DefaultStringValidator : FieldValidator<String> {
    override fun validate(input: String) = input.isNotEmpty()
}

object DefaultIntValidator : FieldValidator<Int> {
    override fun validate(input: Int) = input >= 0
}

object Validators {
    // Öncekiyle aynı map’i kullanır, ancak artık ona dışarıdan access edemezsiniz.
    private val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()

    // Validator’ın bir class ile karşılık geldiği durumda, map’e yalnızca doğru key–value pair’ları koyar.
    fun <T : Any> registerValidator(
        kClass: KClass<T>, fieldValidator: FieldValidator<T>
    ) {
        validators[kClass] = fieldValidator
    }

    // FieldValidator<T>’ye yapılan unchecked cast hakkındaki uyarıyı bastırır.
    @Suppress("UNCHECKED_CAST")
    operator fun <T : Any> get(kClass: KClass<T>): FieldValidator<T> =
        validators[kClass] as? FieldValidator<T>
            ?: throw IllegalArgumentException("No validator for ${kClass.simpleName}")
}


fun main() {
    Validators.registerValidator(String::class, DefaultStringValidator)
    Validators.registerValidator(Int::class, DefaultIntValidator)

    println(Validators[String::class].validate("Kotlin")) // true
    println(Validators[Int::class].validate(42)) // true
}