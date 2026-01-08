# Nullability of type parameters

Varsayılan olarak, Kotlin’de function ve class’ların tüm generic type parameter’ları nullable’dır. Nullable type da
dahil olmak üzere herhangi bir type, bir type parameter yerine geçirilebilir; bu durumda, type parameter T’nin sonunda
question mark olmasa bile, type olarak type parameter kullanan declaration’ların null olmasına izin verilir. Aşağıdaki
example’ı göz önünde bulundur.

```kotlin
fun <T> printHashCode(t: T) {
    // t null olabileceği için safe call kullanmak zorundasın.
    println(t?.hashCode())
}

fun main() {
    // T, Any? olarak inferred edilir.
    printHashCode(null) // null
}
```

printHashCode call’unda, type parameter T için inferred type nullable bir type olan Any?’dir. Bu nedenle, T’den sonra
question mark olmasa bile parameter t’nin null tutmasına izin verilir.

type parameter’ı non-nullable yapmak için onun için non-nullable bir upper bound specify etmen gerekir. Bu, argument
olarak nullable bir value’yu reject eder.

```kotlin
// Artık T nullable olamaz.
fun <T : Any> printHashCode(t: T) {
    println(t.hashCode())
}

fun main() {
    // Bu code compile olmaz: non-null bir value beklendiği için null pass edemezsin.
    printHashCode(null) // null
    // Error: Type parameter bound for `T` is not satisfied
    printHashCode(42) // 42
}
```

Bölüm 11.1.4, Kotlin’de generic’leri daha ayrıntılı olarak ele alır. type parameter’ların, bir type’ı nullable olarak
işaretlemek için sonunda question mark bulunmasının gerekli olduğu ve question mark içermeyen type’ların non-nullable
olduğu kuralının tek istisnası olduğunu unutma. Bir sonraki bölüm, nullability’nin başka bir özel case’ini gösterir:
Java code’dan gelen type’lar.