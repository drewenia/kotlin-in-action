Note : Chapter 5 tamamlandı...

[Chapter 1](src/main/kotlin/ch01)

[Chapter 2](src/main/kotlin/ch02)

[Chapter 3](src/main/kotlin/ch03)

[Chapter 4](src/main/kotlin/ch04)

[Chapter 5](src/main/kotlin/ch05)

# Chapter 1

Kotlin statically typed’dir ve type inference’i destekler; bu sayede source code’u concise tutarken doğruluk ve
performansı koruyabilir.

* Kotlin, hem object-oriented hem de functional programming style’larını destekler; first-class function’lar
  aracılığıyla daha yüksek seviyeli abstraction’lar sağlar ve immutable value desteği sayesinde testing ve multithreaded
  development’i basitleştirir.

* Coroutines, thread’lere hafif bir alternatif sunar ve asenkron code’u doğal hissettirmeye yardımcı olur; böylece,
  mantığı sequential code’a benzer şekilde yazabilir ve concurrent code’u parent–child ilişkileri içinde
  yapılandırabilirsiniz.

* Kotlin, server-side application’lar için uygundur; Ktor ve http4k gibi Kotlin-first framework’ler ve Spring Boot gibi
  mevcut tüm Java framework’lerini tam olarak destekler.

* Android, Kotlin-first’tir; development tool’lar, library’ler, sample’lar ve dokümantasyon ağırlıklı olarak Kotlin’e
  odaklanır.

* Kotlin Multiplatform, Kotlin code’unuzu JVM dışındaki target’lara, iOS ve web dahil, taşır.

* Kotlin ücretsiz ve open source’dur; birden fazla build system ve IDE’yi destekler.

* Otomatik Java-to-Kotlin converter, mevcut code’unuzu ve bilginizi Kotlin’e taşımanıza olanak tanır.

* Kotlin pragmatik, safe, concise ve interoperable’dır; yani yaygın görevler için kanıtlanmış çözümleri kullanmaya
  odaklanır, NullPointerException gibi yaygın hataları önler, kompakt ve kolay okunabilir code sağlar ve Java ile
  sınırsız entegrasyon sunar.

# Chapter 2

* Fun keyword’ü bir function declare etmek için kullanılır. Val ve var keyword’leri sırasıyla read-only ve mutable
  variable’lar declare eder.

* Bir val reference read-only olsa da, işaret ettiği object yine de mutable olabilir.

* String template’ler, karmaşık string concatenation’dan kaçınmanıza yardımcı olur. Bir variable
  adına `$` prefix’i ekleyin veya bir expression’ı `${}` ile çevreleyin, değeri string’e inject edilir.

* Class’lar Kotlin’de kısa bir şekilde ifade edilebilir.

* Alışılmış if artık return value’a sahip bir expression’dır.

* When expression, Java’daki switch’e benzer ama daha güçlüdür.

* Bir variable’ın belirli bir type’a sahip olduğunu kontrol ettikten sonra onu explicit cast etmenize gerek yoktur;
  compiler bunu smart cast kullanarak otomatik yapar.

* For, while ve do-while loop’lar Java’dakine benzer, ancak for loop artık daha kullanışlıdır, özellikle bir map veya
  collection üzerinde index ile iterate etmeniz gerektiğinde.

* Kısa syntax 1..5 (ve 1..<5) bir range oluşturur. Range ve progression’lar, Kotlin’in for loop’larda uniform bir syntax
  ve abstraction seti kullanmasını sağlar ve ayrıca bir value’un bir range’e ait olup olmadığını kontrol eden `in` ve
  `!in` operator’ları ile çalışır.

* Kotlin’de exception handling Java’ya çok benzerdir, fark olarak Kotlin, bir function’ın fırlatabileceği exception’ları
  declare etmenizi gerektirmez.

# Chapter 3

Kotlin, Java collection class’larını daha zengin bir API ile geliştirir.

* Function parameter’ları için default value’lar tanımlamak, overloaded function tanımlama ihtiyacını büyük ölçüde
  azaltır ve named-argument syntax, çok sayıda parameter’a sahip function’ların çağrılarını çok daha okunabilir hale
  getirir.

* Function ve property’ler yalnızca bir class üyesi olarak değil, doğrudan bir file içinde de declare edilebilir; bu,
  daha esnek bir code yapısı sağlar.

* Extension function’lar ve property’ler, source code’unu değiştirmeden ve runtime overhead olmadan, external
  library’lerde tanımlı class’lar da dahil olmak üzere herhangi bir class’ın API’sını genişletmenizi sağlar.

* Infix call’lar, tek bir argument alan operator-benzeri method’ları çağırmak için temiz bir syntax sağlar.

* Kotlin, hem regular expression hem de plain string’ler için çok sayıda kullanışlı string-handling function sunar.

* Triple-quoted string’ler, Java’da çok fazla escape ve string concatenation gerektirecek ifadeleri yazmanın temiz bir
  yolunu sağlar.

* Local function’lar, code’unuzu daha temiz yapılandırmanıza ve duplication’ı ortadan kaldırmanıza yardımcı olur.

# Chapter 4

* Kotlin’deki interface’ler Java’dakilere benzerdir, ancak default implementation’lar ve property’ler içerebilirler.

* Tüm declaration’lar varsayılan olarak final ve public’tir.

* Bir declaration’ı non-final yapmak için open ile işaretlersin.

* internal declaration’lar aynı module içinde görünürdür.

* Nested class’lar varsayılan olarak inner değildir. Outer class’a bir referans saklamak için inner keyword’ünü
  kullanırsın.

* Sealed class’ların tüm direct subclass’ları ve sealed interface’lerin tüm implementation’ları compile time’da
  bilinmelidir.

* Initializer block’lar ve secondary constructor’lar, class instance’larını initialize etmek için esneklik sağlar.

* Accessor body’si içinden bir property backing field’ına referans vermek için field tanımlayıcısını kullanırsın.

* Data class’lar, Compiler tarafından generate edilen equals, hashCode, toString, copy ve diğer method’ları sağlar.

* Class delegation, code’unda birçok benzer delegating method’dan kaçınmana yardımcı olur.

* Object declaration, Kotlin’in singleton bir class define etme yoludur.

* Companion object’ler (package-level function ve property’lerle birlikte) Java’nın static method ve field tanımlarının
  yerini alır.

* Companion object’ler, diğer object’ler gibi interface’leri implement edebilir ve extension function ile property’lere
  sahip olabilir.

* Object expression’lar, Java’nın anonymous inner class’larının Kotlin’deki karşılığıdır ve birden fazla interface
  implement edebilme ve object’in oluşturulduğu scope’ta define edilen variable’ları değiştirebilme gibi ek güçler
  sunar.

* Inline class’lar, çok sayıda kısa ömürlü object allocate edilmesinden kaynaklanan olası performance kayıplarını
  önlerken, programa bir type safety katmanı eklemeni sağlar.

# Chapter 5

* Lambda’lar, kod parçalarını function’lara argument olarak pass etmeni sağlar; böylece common code structure’larını
  kolayca extract edebilirsin.

* Kotlin, lambda’ları parantez dışından function’lara pass etmene izin vererek kodunu clean ve concise hâle getirir.

* Eğer bir lambda yalnızca tek bir parameter alıyorsa, ona implicit adı it ile referans verebilirsin. Bu, kısa ve basit
  lambda’larda tek lambda parameter’ını explicit olarak isimlendirme zahmetini ortadan kaldırır.

* Lambda’lar, external variable’ları capture edebilir. Bu, örneğin, lambda’yı çağıran function içindeki variable’lara
  erişip onları değiştirebileceğin anlamına gelir.

* Method, constructor ve property’lere referans oluşturmak için function adının başına :: ekleyebilirsin. Bu tür
  referansları lambda yerine function’lara pass ederek kısa yol kullanabilirsin.

* Single abstract method (SAM) interface’lerini implement etmek için, interface’i explicit olarak implement eden bir
  object oluşturmak yerine lambda’ları pass edebilirsin.

* Receiver’lı lambda’lar, özel bir receiver object üzerinde doğrudan method call etmene olanak tanır. Bu lambda’ların
  body’si çevreleyen koddan farklı bir context’te execute edildiği için, kodunu yapılandırmana yardımcı olabilir.

* with standart library function’ı, aynı object üzerinde birden fazla method call etmeyi ve object referansını tekrar
  etmeyi gereksiz kılar. apply, herhangi bir object’i builder-style API kullanarak construct ve initialize etmeyi
  sağlar. also ise bir object ile ek action’lar gerçekleştirmene olanak tanır.