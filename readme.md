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