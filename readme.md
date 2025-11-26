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