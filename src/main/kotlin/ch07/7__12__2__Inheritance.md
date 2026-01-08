# Inheritance

Kotlin’de bir Java method’unu override ederken, parameter’ları ve return type’ı nullable ya da non-nullable olarak
declare edip etmeyeceğini seçebilirsin. Örneğin, Java’daki bir StringProcessor interfaces’ine bakalım.

```java
interface StringProcessor {
    void process(String value);
}
```

Kotlin’de, aşağıdaki implementation’ların her ikisi de compiler tarafından kabul edilir.

```kotlin
class StringPrinter : StringProcessor {
    override fun process(value: String) {
        println(value)
    }
}

class NullableStringPrinter : StringProcessor {
    override fun process(value: String?) {
        if (value != null) println(value)
    }
}
```

Java class ya da interface’lerinden method’ları implement ederken nullability’yi doğru ayarlamak önemlidir. Çünkü
implementation method’ları Kotlin dışı code’dan call edilebilir; Kotlin compiler, non-nullable bir type ile declare
ettiğin her parameter için non-null assertion’lar üretir. Java code method’a null bir value pass ederse,
implementation’ında parameter value’ya hiç access etmesen bile bu assertion tetiklenir ve bir exception alırsın.

Nullability ile ilgili tartışmamızı özetleyelim. Nullable ve non-nullable type’ları ve onlarla çalışmanın yollarını ele
aldık: safe operations için operator’lar (safe call ?., Elvis operator ?: ve safe cast as?) ile unsafe dereference için
operator (non-null assertion !!). library function let’in, kısa ve öz non-null check’ler yapmana nasıl yardımcı
olabileceğini ve nullable type’lar için extension’ların, bir non-null check’i bir function içine taşımaya nasıl yardımcı
olabileceğini gördün. Ayrıca Java type’ları Kotlin’de represent eden platform type’ları da ele aldık.