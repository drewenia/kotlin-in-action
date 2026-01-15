Note : Chapter 9 tamamlandı...

# Part 1

[Chapter 1](src/main/kotlin/Part1/ch01)

[Chapter 2](src/main/kotlin/Part1/ch02)

[Chapter 3](src/main/kotlin/Part1/ch03)

[Chapter 4](src/main/kotlin/Part1/ch04)

[Chapter 5](src/main/kotlin/Part1/ch05)

[Chapter 6](src/main/kotlin/Part1/ch06)

[Chapter 7](src/main/kotlin/Part1/ch07)

[Chapter 8](src/main/kotlin/Part1/ch08)

# Part 2

[Chapter 9](src/main/kotlin/Part2/ch09)

[Chapter 10](src/main/kotlin/Part2/ch10)

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

# Chapter 6

* Bir collection içindeki element’ler üzerinde manuel olarak iterating yapmak yerine, en yaygın operations, standard
  library’deki mevcut fonksiyonları kendi lambdas’larınla birleştirerek gerçekleştirilebilir. Kotlin, bu tür
  fonksiyonların geniş bir çeşitliliğiyle birlikte gelir.

* filter ve map fonksiyonları, collection’ları manipulate etmenin temelini oluşturur ve belirli bir predicate ile
  eşleşen element’leri çıkarmayı veya element’leri yeni bir forma transform etmeyi kolaylaştırır.

* reduce ve fold operations, bir collection’dan bilgiyi aggregate eder ve bir item collection’ı verildiğinde tek bir
  value hesaplamana yardımcı olur.

* associate ve groupBy family’lerinden fonksiyonlar, düz list’leri maps’e dönüştürmene yardımcı olur; böylece data’nı
  kendi kriterlerine göre structure edebilirsin.

* indices ile ilişkili collection’lardaki data için, chunked, windowed ve zip fonksiyonları, collection element’lerinden
  alt gruplar oluşturmayı veya birden fazla collection’ı birlikte merge etmeyi mümkün kılar.

* Boolean döndüren lambda fonksiyonları olan predicates kullanarak, all, any, none ve diğer sibling fonksiyonlar,
  belirli invariants’ların collection’ların için geçerli olup olmadığını kontrol etmene olanak tanır.

* Nested collection’larla başa çıkmak için, flatten fonksiyonu nested item’ları çıkarmana yardımcı olabilir; flatMap
  fonksiyonu ise aynı adımda bir transformation gerçekleştirmeyi bile mümkün kılar.

* Sequences, bir collection üzerindeki birden fazla operation’ı lazily ve intermediate (ara) result'ları tutacak
  collection’lar oluşturmadan birleştirmeni sağlar; bu da code’unu daha efficient hale getirir. Collection’lar için
  kullandığın aynı fonksiyonları, sequence’leri manipulate etmek için de kullanabilirsin.

# Chapter 7

* Kotlin’in nullable type’lara verdiği destek, olası NullPointerException hatalarını compile time’da tespit eder.

* Regular type’lar, açıkça nullable olarak işaretlenmedikçe, varsayılan olarak non-nullable’dır. Bir type adının
  sonundaki question mark, onun nullable olduğunu gösterir.

* Kotlin, nullable type’larla kısa ve öz şekilde çalışmak için çeşitli araçlar sağlar.

* Safe call (?.), nullable object’lar üzerinde method çağırmanı ve property’lere erişmeni sağlar.

* Elvis operator (?:), null olabilecek bir expression için varsayılan bir value sağlamayı, execution’dan return etmeyi
  veya exception fırlatmayı mümkün kılar.

* Non-null assertion (!!) kullanarak compiler’a belirli bir value’nun null olmadığını garanti edebilirsin (ama bu
  garantiyi bozarsan bir exception almayı beklemelisin).

* let scope function, çağrıldığı object’i bir lambda için parameter hâline getirir. Safe-call operator ile birlikte
  kullanıldığında, nullable type’lı bir object’i etkin bir şekilde non-nullable type’a dönüştürür.

* as? operator, bir value’yu bir type’a cast etmenin ve farklı bir type’a sahip olduğu durumda durumu handle etmenin
  kolay bir yolunu sağlar.

# Chapter 8

* basic sayıları represent eden type’lar (örneğin Int), normal class’lar gibi görünür ve davranır ancak genellikle Java
  primitive type’larına compile edilir. JVM üzerinde birebir karşılığı olmayan Kotlin unsigned number class’ları, inline
  class’lar aracılığıyla primitive type’lar gibi davranacak ve performans gösterecek şekilde dönüştürülür.

* Nullable primitive type’lar (örneğin Int?) Java’daki boxed primitive type’lara karşılık gelir (örneğin
  java.lang.Integer).

* Any type, diğer tüm type’ların supertype’ıdır ve Java’daki Object’e benzerdir. Unit, void’in bir karşılığıdır.

* Nothing type, normal şekilde sonlanmayan function’ların dönüş type’ı olarak kullanılır.

* Java’dan gelen type’lar, Kotlin’de platform type’lar olarak yorumlanır ve developer’ın bunları nullable ya da non-null
  olarak ele almasına izin verir.

* Kotlin, collection’lar için standart Java class’larını kullanır ve bunları read-only ve mutable collection’lar
  arasındaki bir ayrımla geliştirir.

* Kotlin’de Java class’larını extend ederken veya Java interface’lerini implement ederken, parameter’ların nullability
  ve mutability özelliklerini dikkatlice göz önünde bulundurmalısınız.

* Kotlin’de array’leri kullanabilirsiniz, ancak genel olarak varsayılan olarak collection’ları tercih etmeniz önerilir.

* Kotlin’in Array class’ı normal bir generic class gibi görünür ancak Java array’ine compile edilir.

* Primitive type’ların array’leri, IntArray gibi özel class’lar tarafından represent edilir.

# Chapter 9

* Kotlin, karşılık gelen isimlere sahip function’lar define ederek bazı standart matematiksel operation’ları overload
  etmene izin verir. Kendi operator’larını define edemezsin, ancak daha ifade edici bir alternatif olarak infix
  function’ları kullanabilirsin.

* Herhangi bir object ile comparison operator’larını (==, !=, >, < vb.) kullanabilirsin. Bunlar, equals ve compareTo
  method’larına yapılan call’lara mapping edilir.

* get, set ve contains isimli function’ları define ederek, class’ını Kotlin collection’larına benzer hale getirmek
  için `[]` ve `in` operator’larını destekleyebilirsin.

* Range’ler oluşturmak ve collection’lar ile array’ler üzerinde iterate etmek de convention’lar aracılığıyla çalışır.

* Destructuring declaration’lar, tek bir object’i unpack ederek birden fazla variable’ı initialize etmene olanak tanır;
  bu, bir function’dan birden fazla value döndürmek için kullanışlıdır. data class’lar ile automatically çalışırlar ve
  componentN isimli function’ları define ederek kendi class’ların için de destekleyebilirsin.

* Delegated property’ler, property value’larının nasıl store edildiğini, initialize edildiğini, access edildiğini ve
  modify edildiğini kontrol eden logic’i yeniden kullanmana olanak tanır; bu da framework’ler oluşturmak için güçlü bir
  araçtır.

* lazy standard library function’ı, lazily initialize edilen property’leri implement etmek için kolay bir yol sunar.

* `Delegates.observable` function’ı, property change’lerinin bir observer’ını eklemene olanak tanır.

* Delegated property’ler, herhangi bir map’i property delegate olarak kullanabilir ve variable attribute set’lerine
  sahip object’lerle çalışmak için esnek bir yol sunar.