package ch04

import java.net.URI

/* Genel olarak konuşmak gerekirse, birden fazla constructor’a sahip class’lar Kotlin code’unda Java’ya kıyasla çok daha
az yaygındır. Overloaded constructor’lara ihtiyaç duyacağınız çoğu durum, Kotlin’in default parameter value’ları ve
named argument syntax’ı desteğiyle karşılanır. Argument’lar için overload yapmak ve default value’lar sağlamak amacıyla
birden fazla secondary constructor declare etmeyin. Bunun yerine, default value’ları doğrudan belirtin. Ancak yine de
birden fazla constructor’ın gerekli olduğu durumlar vardır. En yaygın olanı, class’ı farklı şekillerde initialize eden
birden fazla constructor sağlayan bir framework class’ını extend etmeniz gerektiğinde ortaya çıkar. Örneğin, Java’da
declare edilmiş ve biri parameter olarak String, diğeri URI alan iki constructor’a sahip bir Downloader class’ını ele
alalım: */

/*
import java.net.URI;

public class Downloader422Java {
    public Downloader422Java(String url){
        // some code
    }

    public Downloader422Java(URI uri){
        // some code
    }
}
*/

/* Kotlin’de aynı declaration aşağıdaki gibi görünür: */

open class Downloader422 {
    // Secondary constructor
    constructor(url : String?) {
        // some code
    }

    constructor(uri : URI?){
        // some code
    }
}

/* Bu class bir primary constructor declare etmez (bunu, class header’ında class adından sonra parantez olmamasından
anlayabilirsiniz), ancak iki secondary constructor declare eder. Bir secondary constructor, constructor keyword’ü
kullanılarak tanımlanır. İhtiyacınız olduğu kadar secondary constructor declare edebilirsiniz. Bu class’ı extend etmek
istiyorsanız, aynı constructor’ları declare edebilirsiniz: */

class MyDownloader422 : Downloader422{
    // Superclass constructor’larının call edilmesi
    constructor(url : String?) : super(url) {
        // ...
    }

    // Superclass constructor’larının call edilmesi
    constructor(uri : URI) : super(uri) {
        // ...
    }
}

/* Burada, her biri super() keyword’ünü kullanarak superclass’ın karşılık gelen constructor’ını call eden iki
constructor tanımlarsınız. Bu durum img_5.png'de gösterilmiştir; bir ok, hangi constructor’a delegation yapıldığını
gösterir. Java’daki gibi, bir constructor içinden kendi class’ınızın başka bir constructor’ını this() keyword’ünü
kullanarak call etme seçeneğiniz de vardır: */

class MyDownloader422v2 : Downloader422 {
    // this Class’ın başka bir constructor’ına delegation yapar
    constructor(url : String?) : this(URI(url))
    constructor(uri : URI?) : super(uri)
}

/* MyDownloader class’ını, constructor’lardan birinin aynı class’ın diğer constructor’ına (this kullanarak) delegation
yapacak şekilde değiştirirsiniz; böylece url string’inden bir URI object’i oluşturulur; bu durum img_6.png'de
gösterilmiştir. İkinci constructor ise super()’ı call etmeye devam eder. */

/* Eğer class’ın bir primary constructor’ı yoksa, her secondary constructor ya base class’ı initialize etmeli ya da bunu
yapan başka bir constructor’a delegation yapmalıdır. Önceki şekiller açısından düşünürsek, her secondary constructor,
base class’ın herhangi bir constructor’ında sona eren bir yol başlatan dışa doğru bir oka sahip olmalıdır. Secondary
constructor’ları kullanmanız gereken başlıca kullanım durumu Java interoperability’dir. Ancak başka bir olası durum daha
vardır: class’ınızın instance’larını farklı parameter list’leriyle oluşturmanın birden fazla yolu olduğunda. Bunun bir
örneğini daha sonra ele alacağız. Nontrivial constructor’ların nasıl tanımlanacağını ele aldık. Şimdi dikkatimizi
nontrivial property’lere çevirelim. */