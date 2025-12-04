package ch01

/*

Kotlin, compiled bir dildir; yani Kotlin kodunu çalıştırmadan önce compile etmeniz gerekir. Kotlin code farklı
target’lara compile edilebilir:

* JVM bytecode (.class file’larında saklanır) — JVM üzerinde çalıştırmak için

* JVM bytecode — Android üzerinde çalıştırılmak üzere daha sonra dönüştürülmek için

* Native target’lar — farklı işletim sistemlerinde native olarak çalıştırmak için

* JavaScript (ve WebAssembly) — bir browser içinde çalıştırmak için

Kotlin compiler için, üretilen JVM bytecode’unun JVM üzerinde mi çalıştığı yoksa daha sonra dönüştürülüp Android
üzerinde mi çalıştığı önemli değildir. Android Runtime (ART), JVM bytecode’u Dex bytecode’a dönüştürür ve bunun yerine
onu çalıştırır. En basit durumda, kodunuzu command line’dan derlemek için **kotlinc** komutunu ve çalıştırmak için
**java** komutunu kullanabilirsiniz:

kotlinc <source file or directory> -include-runtime -d <jar name>
java -jar <jar name>

Bir JVM, .class dosyalarının başlangıçta Java mı yoksa Kotlin ile mi yazıldığını bilmeden Kotlin kodundan compile
edilmiş **.class** dosyalarını çalıştırabilir. Ancak Kotlin built-in class’lar ve onların API’leri Java’dakilerden
farklıdır ve compile edilen kodun doğru şekilde çalışabilmesi için JVM’in ek bilgiye, yani **Kotlin runtime library**’ye
bağımlılığı vardır. Command line’dan kod derlerken, bu runtime library’i ortaya çıkan JAR dosyasına dahil etmek için
**-include-runtime** parametresini explicitly kullandık. Kotlin runtime library, application’ınızla birlikte distrubute
edilmek zorundadır; Kotlin’in temel class’ları olan Int ve String gibi class’ların tanımlarını ve Kotlin’in standart
Java API’lerine eklediği bazı extension’ları içerir. Kotlin standard library’nin application’ınızda bir dependency
olarak dahil edilmesi gerekir. Teorik olarak, Kotlin kodunu bunu kullanmadan yazabilirsiniz, ancak pratikte buna hiç
ihtiyaç duyulmaz. Standard library, List, Map ve Sequence gibi temel class’ların tanımlarını ve bunlarla çalışmak için
birçok method’u içerir.

Kotlin build process'ini görsel olarak görmek için ch01 içerisinde img.png'ye bakın

*/