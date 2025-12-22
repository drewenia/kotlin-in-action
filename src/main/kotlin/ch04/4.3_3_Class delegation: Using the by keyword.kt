package ch04

/* Büyük object-oriented sistemlerin tasarımında yaygın bir problem, implementation inheritance’ın neden olduğu
kırılganlıktır. Bir class’ı extend edip onun bazı method’larını override ettiğinde, kodun extend ettiğin class’ın
implementation ayrıntılarına bağımlı hale gelir. Sistem geliştikçe ve base class’ın implementation’ı değiştiğinde ya da
ona yeni method’lar eklendiğinde, class’ında onun behavior’ı hakkında yaptığın varsayımlar geçersiz hale gelebilir; bu
nedenle kodun doğru şekilde davranmayabilir. Kotlin’in design’ı bu problemi kabul eder ve class’ları varsayılan olarak
final kabul eder. Bu, yalnızca extensibility için tasarlanmış class’lardan inheritance yapılabilmesini sağlar. Böyle bir
class üzerinde çalışırken onun open olduğunu görürsün ve yapılan değişikliklerin derived class’larla uyumlu olması
gerektiğini aklında tutabilirsin. Ancak çoğu zaman, extensibility için tasarlanmamış olsa bile başka bir class’a
behavior eklemen gerekir. Bunun için yaygın bir implementation yolu decorator design pattern olarak bilinir. Pattern’ın
özü, orijinal class ile aynı interface’i implement eden ve orijinal class’ın instance’ını bir field olarak saklayan yeni
bir class oluşturulmasıdır. Orijinal class’ın behavior’ının değiştirilmesine gerek olmayan method’lar, orijinal class
instance’ına yönlendirilir. Bu yaklaşımın bir dezavantajı, oldukça büyük miktarda boilerplate code gerektirmesidir
(o kadar ki IntelliJ IDEA gibi bazı IDE’ler bu code’u senin için generate etmeye yönelik özel özelliklere sahiptir).
Örneğin, behavior’da herhangi bir değişiklik yapmadığın durumda bile, Collection kadar basit bir interface’i implement
eden bir decorator için ihtiyaç duyulan code miktarı şöyledir: */

class DelegatingCollection433<T> : Collection<T> {
    private val innerList = arrayListOf<T>()
    override val size: Int get() = innerList.size
    override fun isEmpty(): Boolean = innerList.isEmpty()
    override fun contains(element: T): Boolean = innerList.contains(element)
    override fun iterator(): Iterator<T> = innerList.iterator()
    override fun containsAll(elements: Collection<T>): Boolean =
        innerList.containsAll(elements)
}

fun main() {
    val numbers = DelegatingCollection433v2(listOf(1, 2, 3))
    println(numbers.size) // 3
    println(numbers.contains(2)) // true

    val numbers2 = DelegatingCollection433v2<Int>()
    // aşağıdaki add methodu compile edilmez. Çünkü Class Collection<T> implement ediyor ve Collection<T> read-only
    // numbers2.add(5)

    val cset = CountingSet433<Int>()
    cset.addAll(listOf(1, 1, 2))
    println("Added ${cset.objectsAdded} objects, ${cset.size} uniques") // Added 3 objects, 2 uniques
}

/* İyi haber şu ki Kotlin, bir language feature olarak delegation için first-class support içerir. Bir interface’i
implement ettiğin her durumda, by keyword’ünü kullanarak interface’in implementation’ını başka bir object’e delegate
ettiğini söyleyebilirsin. Önceki örneği yeniden yazmak için bu yaklaşımı şu şekilde kullanabilirsin: */

class DelegatingCollection433v2<T>(
    innerlist: Collection<T> = mutableListOf<T>()
) : Collection<T> by innerlist

/* Bu class interface delegation kullandığı için, instatiate edilirken aslında normal bir Collection gibi davranır.
Collection<T> interface’inin tüm method’ları innerList objesine delegate edilir. main method içerisinde
örneklendirdim */

/* Class içindeki tüm method implementation’ları ortadan kalkmıştır. Compiler bunları generate eder ve implementation,
DelegatingCollection örneğindekine benzerdir. Code’da ilginç bir içerik pek olmadığı için, compiler aynı işi otomatik
olarak senin adına yapabiliyorken bunu manuel olarak yazmanın bir anlamı yoktur. Artık bazı method’ların behavior’ını
değiştirmeye ihtiyaç duyduğunda, onları override edebilirsin ve generated method’lar yerine senin code’un call edilir.
Underlying instance’a delegate eden default implementation’dan memnun olduğun method’ları ise dışarıda bırakabilirsin.
Bu tekniği, kendisine bir element ekleme girişimlerinin sayısını sayan bir collection implement etmek için nasıl
kullanabileceğine bakalım. Örneğin, bir tür deduplication yapıyorsan, böyle bir collection’ı kullanarak bir element
ekleme girişimlerinin sayısını collection’ın ortaya çıkan size’ı ile compared ederek process’in ne kadar efficient
olduğunu ölçebilirsin. */

class CountingSet433<T>(
    private val innerSet: MutableCollection<T> = hashSetOf()
    // MutableCollection implementation’ını innerSet’e delegate eder
) : MutableCollection<T> by innerSet {

    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }
}

/* Main methodu içerisine örnek kullanımı koydum. Gördüğün gibi, sayacı artırmak için add ve addAll method’larını
override edersin ve MutableCollection interface’inin geri kalan implementation’ını, sarmaladığın container’a delegate
edersin. Önemli olan nokta, alttaki collection’ın nasıl implement edildiğine dair hiçbir dependency oluşturmamandır.
Örneğin, bu collection’ın addAll’ü bir loop içinde add call ederek mi implement ettiğini yoksa belirli bir case için
optimize edilmiş farklı bir implementation mı kullandığını umursamazsın. Client code senin class’ını call ettiğinde ne
olacağı üzerinde tam kontrole sahipsindir ve operation’larını implement etmek için yalnızca alttaki collection’ın
belgelenmiş API’sine dayanırsın; dolayısıyla bunun çalışmaya devam edeceğine güvenebilirsin. Artık Kotlin compiler’ın
class’lar için nasıl faydalı method’lar generate edebildiğini gördün. Şimdi Kotlin’in class hikâyesinin son büyük
bölümüne geçelim: object keyword’ü ve bunun devreye girdiği farklı durumlar. */