package ch05

/* Bir SAM constructor, single abstract method’a sahip bir interface’in instance’ına bir lambda’yı açıkça dönüştürmeni
sağlayan, compiler tarafından generated edilmiş bir function’dır. Compiler’ın dönüşümü automatically uygulamadığı
context’lerde bunu kullanabilirsin. Örneğin, functional interface’in bir instance’ını döndüren bir method’un varsa,
doğrudan bir lambda return edemezsin; onu bir SAM constructor içine wrap etmen gerekir. İşte basit bir example. */

fun createAllDoneRunnable522(): Runnable {
    return Runnable { println("All done!") }
}

/* SAM constructor’ın adı, alttaki functional interface’in adıyla aynıdır. SAM constructor tek bir argument alır —
functional interface’teki single abstract method’un body’si olarak kullanılacak bir lambda — ve interface’i implement
eden class’ın bir instance’ını döndürür. Value döndürmenin yanı sıra, SAM constructor’lar bir lambda’dan generated
edilmiş bir functional interface instance’ını bir variable’da store etmen gerektiğinde de kullanılır. Diyelim ki
aşağıdaki listede olduğu gibi birden fazla button için tek bir listener’ı reuse etmek istiyorsun (bir Android
application’da bu kod, Activity.onCreate method’unun bir parçası olabilir).

val listener = OnClickListener { view ->
    val text = when (view.id) {
        button1.id -> "First button"
        button2.id -> "Second button"
        else -> "Unknown button"
    }
    toast(text)
}

button1.setOnClickListener(listener)
button2.setOnClickListener(listener)

Listener, click’in kaynağının hangi button olduğunu kontrol eder ve buna göre behavior sergiler. OnClickListener’ı
implement eden bir object declaration kullanarak bir listener define edebilirsin, ancak SAM constructor’lar daha concise
bir seçenek sunar. Bir lambda’da, anonymous object’te olduğu gibi bir this yoktur; lambda’nın dönüştürüldüğü anonymous
class instance’ına referans vermenin bir yolu yoktur. Compiler açısından lambda bir object değil, bir code block’tur ve
onu bir object olarak referans edemezsin. Lambda’daki this referansı, surrounding class’a referans verir. Eğer event
listener, bir event’i handle ederken kendisini unsubscribe etmek zorundaysa, bunun için lambda kullanamazsın. Bunun
yerine, listener’ı implement etmek için bir anonymous object kullan. Anonymous object’te this keyword’ü o object’in
instance’ına referans verir ve listener’ı kaldıran API’ye onu pass edebilirsin. Ayrıca, method call’larda SAM conversion
genellikle automatically gerçekleşse bile, overloaded bir method’a lambda’yı argument olarak pass ettiğinde compiler’ın
doğru overload’u seçemediği durumlar vardır. Bu durumlarda, explicit bir SAM constructor uygulamak compilation error’ı
çözmenin iyi bir yoludur. */

fun main() {
    createAllDoneRunnable522().run() // All done!
}