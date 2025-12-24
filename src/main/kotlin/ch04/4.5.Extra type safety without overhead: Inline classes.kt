package ch04

/* Data class’lar ile compiler tarafından generate edilen code’un, code’unu okunabilir ve dağınıklıktan uzak tutmana
nasıl yardımcı olduğunu zaten gördün. Şimdi Kotlin compiler’ın gücünü gösteren başka bir örneğe bakalım:
inline class’lar. Bir an için, harcamalarını takip etmek üzere basit bir sistem inşa ettiğini varsayalım: */

fun addExpense45(expense : Int){
    // save the expense as USD cent
}

/* Japonya’ya yapacağın bir sonraki seyahat sırasında, sana ¥200’ye mal olan lezzetli bir Nikuman’ın (buharda pişirilmiş
çörek) faturasını eklemek istiyorsun: */

fun main() {
    addExpense45(200) // Japanese Yen
    addExpense45v2(UsdCent45(147))
    calculate45()
}

/* Problem oldukça hızlı bir şekilde ortaya çıkar: function’ın signature’ı sade bir Int kabul ettiği için, function’ı
call edenlerin gerçekte farklı semantics’e sahip value’lar geçmesini engelleyen hiçbir şey yoktur. Bu durumda, actual
implementation geçirilen value’nun “USD cent” anlamına gelmesini gerektirirken, caller’ın parameter’ı “yen” olarak
yorumlamasını engelleyen hiçbir şey yoktur. Bunu engellemenin klasik yaklaşımı, sade bir Int yerine bir class
kullanmaktır: */

class UsdCent45(val amount : Int)

fun addExpense45v2(expense : UsdCent45) {
    // save the expense as USD cent
}

/* Bu yaklaşım, function’a yanlış semantics’e sahip bir value’un yanlışlıkla geçirilme olasılığını önemli ölçüde
azaltsa da, bazı performance değerlendirmelerini beraberinde getirir: her addExpense function call’ı için yeni bir
UsdCent object’i oluşturulması gerekir; bu object daha sonra function body’si içinde açılır ve atılır. Eğer bu function
sıkça call edilirse, çok sayıda kısa ömürlü object allocate edilir ve ardından garbage collected edilir. İşte bu noktada
inline class’lar devreye girer. Performance’dan ödün vermeden bir type safety katmanı eklemene olanak tanırlar. UsdCent
class’ını bir inline class’a dönüştürmek için, onu value keyword’ü ile işaretler ve ardından @JvmInline annotation’ı ile
annotate edersin: */

@JvmInline
value class UsdCent45v2(val amount : Int)

/* Bu küçük değişiklik, UsdCent wrapper type’ının sağladığı type safety’den vazgeçmeden gereksiz object
instantiation’larını önler. Runtime’da, UsdCent instance’ları sarmalanmış property olarak represent edilir. Inline
class’ların isimlerini aldığı yer de burasıdır: class’ın data’sı kullanım noktalarında inline edilir. */

/* NOT Tam olarak doğru olmak gerekirse, Kotlin compiler inline class’ı mümkün olan her yerde onun underlying type’ı
olarak represent eder. Wrapper type’ı korumanın gerekli olduğu durumlar vardır — en belirgin olarak, inline class bir
type parameter olarak kullanıldığında. */

/* “Inline” olarak nitelendirilebilmesi için, class’ının tam olarak bir property’si olmalıdır ve bu property primary
constructor içinde initialize edilmelidir. Inline class’lar ayrıca class hierarchy’lerine katılmazlar: başka class’ları
extend etmezler ve kendileri de extend edilemezler. Ancak yine de interface’leri implement edebilir, method’lar define
edebilir ya da computed property’ler sağlayabilirler. */

interface PrettyPrintable45{
    fun prettyPrint()
}

@JvmInline
value class UsdCent45v3(val amount : Int) : PrettyPrintable45 {
    val salesTax get() = amount * 0.06
    override fun prettyPrint() = println("${amount}¢")
}

fun calculate45() {
    val expense = UsdCent45v3(1_99)
    println(expense) // UsdCent45v3(amount=199)
    println(expense.salesTax) // 11.94
    expense.prettyPrint() // 199¢
}

/* Inline class’lara çoğunlukla temel value’ların semantics’ini açık hale getirmek için başvurursun; örneğin sade number
type’ları için kullanılan ölçü birimlerini belirtmek ya da farklı string’lerin anlamlarını ayırt etmek gibi. Function
caller’ların, semantics’i farklı olan ancak uyumlu value’ları yanlışlıkla geçmesini engellerler. */

/* Inline class için bir problem ve çözümü */

fun transfer45 (from : Int, to : Int, amount : Int){}

/* Buradaki problem şu: from, to, amount hepsi Int. Compiler anlam farkını bilmiyor.Yanlış parametre sırası → sessiz
bug.

Inline class = “Bu Int ne anlama geliyor?” demek
*/

@JvmInline
value class UserId45(val value : Int)

@JvmInline
value class Amount45(val value : Int)

fun transfer45v2(from : UserId45, to : UserId45, amount : Amount45){
    // ...
}

fun transferAmount45(){
    transfer45v2(UserId45(1), UserId45(4), Amount45(45))

    // compile edilmez
    //transfer45v2(Amount45(45), UserId45(11), UserId45(22))
}

/*
val id = UserId45(5)

JVM’de bu şuna dönüşür: int 5 Object yok, GC yok, Wrapper maliyeti yok. Bu yüzden adı inline. Kurallar (çok basit)
Sadece 1 property, Runtime’da primitive gibi davranır Yanlış kullanım compile-time error üretir
*/