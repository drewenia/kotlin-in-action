package ch03

/* Java’nın varsayılan parametre değeri kavramı olmadığı için, varsayılan parametre değerleri olan bir Kotlin
fonksiyonunu Java’dan çağırırken tüm parametre değerlerini açıkça belirtmeniz gerekir. Eğer bir fonksiyon Java’dan
sık sık çağrılıyorsa ve Java çağıranlar için kullanımını kolaylaştırmak istiyorsanız, onu @JvmOverloads ile
anotasyonlayabilirsiniz. Bu anotasyon, derleyiciye Java için overload edilmiş metotlar üretmesini söyler ve bu metotlar
son parametreden başlayarak parametreleri teker teker atlar. Örneğin, joinToString fonksiyonunuzu aşağıdaki listede
gösterildiği gibi @JvmOverloads ile anotasyonlayabilirsiniz.*/

@JvmOverloads
fun <T> joinToStringOverloads(
    collection : Collection<T>,
    seperator : String = ", ",
    prefix : String = "",
    postfix : String = ""
) : String {
    val text = StringBuilder(prefix)
    for ((index,element) in collection.withIndex()){
        if(index > 0) text.append(seperator)
        text.append(element)
    }
    text.append(postfix)
    return text.toString()
}

/* JAVA'da otomatik olarak oluşturulacak overload methodlar @JvmOverloads anotasyonu ile
String joinToString(Collection<T> collection, String separator,
String prefix, String postfix);
String joinToString(Collection<T> collection, String separator, String prefix);
String joinToString(Collection<T> collection, String separator);
String joinToString(Collection<T> collection);
*/