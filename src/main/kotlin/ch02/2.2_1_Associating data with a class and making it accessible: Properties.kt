package ch02

/* Bir class'ın fikri, veriyi ve o veri üzerinde çalışan kodu tek bir entity içinde encapsulate etmektir. Java'da veri,
genellikle private olan field'larda saklanır. Eğer class'ın client'larının bu verilere erişmesine izin vermeniz
gerekiyorsa, accessor method'ları sağlarsınız: bir getter ve muhtemelen bir setter. Bunu Person class'ında bir örnekle
gördünüz. Setter ayrıca geçirilen değeri doğrulamak, değişiklik hakkında bildirim göndermek ve benzeri ek logic
içerebilir. Java'da, field ile onun accessor'larının birleşimi genellikle bir property olarak adlandırılır ve birçok
framework bu kavramı yoğun şekilde kullanır. Kotlin'de, property'ler, field'ları ve accessor method'larını tamamen
yerine geçen bir birinci sınıf dil özelliğidir. Bir class içinde property declare etmek, bir variable declare etmekle
aynı şekilde yapılır: val ve var keyword'leri ile. Val olarak declare edilen bir property yalnızca okunabilirken, var
property mutable'dır ve değiştirilebilir. Örneğin, zaten yalnızca okunabilir bir name property içeren Person
class'ınızı, mutable bir isStudent property ile genişletebilirsiniz. */

class Person221(
    val name : String, // Read-only property — bir field ve basit bir getter oluşturur
    var isStudent : Boolean // Writable property—bir field, getter ve setter
)

/* Temelde, bir property declare ettiğinizde, karşılık gelen accessor'ları declare etmiş olursunuz (yalnızca okunabilir
bir property için bir getter ve writable bir property için hem getter hem setter). Varsayılan olarak, bu accessor'ların
implementasyonu basittir; değeri saklamak için bir field oluşturulur, getter bu field'ın değerini döndürür ve setter
değerini günceller. Ancak isterseniz, property değerini hesaplamak veya güncellemek için farklı bir logic kullanan özel
bir accessor declare edebilirsiniz. Person221 sınıfının concise declaration’ı, orijinal Java koduyla aynı underlying
implementation’ı gizler: Bu, constructor içinde initialize edilen private field’lara sahip bir sınıftır ve ilgili getter
üzerinden erişilebilir. Bu durum, bu sınıfı Java’dan da Kotlin’den de aynı şekilde kullanabileceğiniz anlamına gelir;
hangi yerde declare edildiğinden bağımsız olarak kullanım aynıdır. Kullanım görünümü birebir aynıdır. Aşağıda ki
(Demo221) Kotlin sınıfı Person221’ın Java kodundan nasıl kullanılacağını görebilirsiniz; Ocean adında yeni bir
Person221 object oluşturuluyor, kendisi bir student. */

/*
public class Demo221 {
    public static void main(String[] args) {
        Person221 person = new Person221("Ocean",true);
        System.out.println(person.getName()); // Ocean
        System.out.println(person.isStudent()); // true
        person.setStudent(false);
        System.out.println(person.isStudent()); // false
    }
}*/

/* Kotlin’de tanımlanan Person221, Java’dan kullanılırken Java’daki ile tamamen aynı şekilde görünür. Kotlin’in name
property’si, Java tarafında getName adlı bir getter method’u olarak ortaya çıkar.*/

fun main(){
    val person221 = Person221("Bob",true)
    println("Person name : ${person221.name} is student? : ${person221.isStudent}")
    person221.isStudent = false
    println(person221.isStudent)
}

/* Artık getter’ı explicityly çağırmak yerine, property’yi doğrudan reference ediyorsun. Mantık aynı kalıyor, ancak kod
daha concise hâle geliyor. Mutable property’lerin setter’ları da aynı şekilde çalışır. Java’da bir graduation’ı
simgelemek için person.setStudent(false) kullanırken, Kotlin’de property syntax’ını doğrudan kullanır ve
person.isStudent = false yazarsın. Çoğu durumda, property değerini yalnızca saklayan karşılık gelen bir backing field
bulunur. Ama değer anında hesaplanabiliyorsa (örneğin diğer property’lerden türetilerek), bunu custom bir getter
kullanarak ifade edebilirsin.
 */
