package ch04

import java.net.URI

/* Genel olarak konuşursak, birden fazla constructor’a sahip class’lar Kotlin kodunda Java’ya göre çok daha az
yaygındır. Overloaded constructor’lara ihtiyaç duyacağınız çoğu durum, Kotlin’in default parameter value desteği ve
named argument syntax’ı tarafından karşılanır. Argümanlar için default value sağlamak ve overload yapmak amacıyla
birden fazla secondary constructor declare etmeyin. Bunun yerine, default value’ları doğrudan belirtin.
*/

/* Ancak yine de birden fazla constructor’ın gerektiği durumlar vardır. En yaygın olanı, class’ı farklı şekillerde
initialize eden birden fazla constructor sağlayan bir framework class’ını extend etmeniz gerektiğinde ortaya çıkar.
Örneğin, Java’da declare edilmiş ve biri String, diğeri URI alan iki constructor’a sahip bir Downloader class’ını ele
alalım:
*/

/*
public class Downloader {
    public Downloader(String url) {
        // some code
    }
}

public Downloader(URI uri) {
    {
        // some code
    }
}
*/

open class Downloader{
    // Secondary constructor
    constructor(url : String?){
        // some code
    }

    constructor(uri : URI?){
        // some code
    }
}

/* Bu class bir primary constructor declare etmez (bunu, class header’daki class adından sonra parantez olmamasından
anlayabilirsiniz), ancak iki secondary constructor declare eder. Bir secondary constructor, constructor keyword’ü
kullanılarak tanıtılır. İhtiyacınız kadar secondary constructor declare edebilirsiniz. Bu class’ı extend etmek
istiyorsanız, aynı constructor’ları declare edebilirsiniz:
*/

class MyDownloader : Downloader {
    // Calling superclass constructors
    constructor(url : String) : super(url)
    constructor(uri : URI) : super(uri)
}

/* Burada, iki constructor tanımlarsın ve her biri, super() keyword'ünü kullanarak superclass’ın ilgili constructor’ına
çağrı yapar. Bu, img_1.png’de gösterilmiştir; bir ok hangi constructor’a delegate edildiğini gösterir.*/

/* MyDownloader class’ını değiştirirsin, böylece constructor’lardan biri (this kullanarak) aynı class’ın diğer
constructor’ına delegate eder ve url string’inden bir URI object oluşturur; bu, img_2.png'de gösterildiği gibidir.
İkinci constructor super() çağrısı yapmaya devam eder.*/

/* Eğer class’ın bir primary constructor’ı yoksa, her secondary constructor base class’ı initialize etmeli ya da bunu
yapan başka bir constructor’a delegate etmelidir. Önceki resimlerde gördüğümüz açısından düşünürsek, her secondary
constructor’ın, base class’ın herhangi bir constructor’ında sona eren bir path başlatan bir dışa doğru okunun olması
gerekir. Secondary constructor kullanman gereken ana kullanım durumu Java interoperability’dir. Fakat başka bir olası
durum daha vardır: class’ının instance’larını farklı parameter list’leriyle oluşturmanın birden fazla yolu olduğunda.
Nontrivial constructor’ların nasıl tanımlanacağını konuştuk. Şimdi dikkatimizi nontrivial properties’e çevirelim.
*/

