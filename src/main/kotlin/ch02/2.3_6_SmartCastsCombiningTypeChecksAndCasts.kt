package ch02

/* Artık Kotlin ile birkaç rengi başarıyla karıştırdığına göre, biraz daha karmaşık bir örneğe geçelim. (1 + 2) + 4
gibi basit aritmetik expression’ları değerlendiren bir function yazacaksın. Expression’lar yalnızca tek bir operation
türü içerecek: iki sayının toplamı. Diğer aritmetik operation’lar (örneğin subtraction, multiplication ve division)
benzer şekilde implement edilebilir ve bunu bir egzersiz olarak yapabilirsin. Bu süreçte, farklı type’larda Kotlin
object’leriyle çalışmayı smart cast’lerin nasıl çok daha kolay hale getirdiğini öğreneceksin. Önce, expression’ları
nasıl encode edeceksin? Geleneksel olarak bunları tree benzeri bir structure içinde saklarsın; burada her node ya bir
sum (Sum) ya da bir number (Num) olur. Num her zaman bir leaf node’dur, Sum ise iki child’a sahiptir: sum operation’ının
argümanları. Aşağıdaki kod, expression’ları encode etmek için kullanılan basit class structure’ını gösterir: Expr adlı
bir interface ve bunu implement eden iki class, Num ve Sum. Expr interface’ının herhangi bir method declare etmediğine
dikkat et; farklı türde expression’lar için ortak bir type sağlamak üzere bir marker interface olarak kullanılır. Bir
class’ın bir interface implement ettiğini belirtmek için, aşağıdaki kod'da gösterildiği gibi, iki nokta (:) ve ardından
interface adı kullanırsın. */

interface Expr236

/* Expr interface’ını implement eden, value adlı tek bir property’e sahip basit bir class. */
class Num236(val value: Int) : Expr236

/* Bir Sum operation’ının argümanı herhangi bir Expr olabilir: Num ya da başka bir Sum */
class Sum236(val left: Expr236, val right: Expr236) : Expr236

/* Görseli img_2.png de görebilirsin. Expr, Num ve Sum arasındaki ilişkiyi gösteren class diyagramı. Num ve Sum, marker
interface olan Expr’ı realize eder. Sum ayrıca left ve right operand’larla bir association’a sahiptir ve bu operand’lar
yine Expr type’ındadır. */

/* Sum, Expr type’ında left ve right argümanlarına referanslar saklar. Senin örneğinde, bunlar Num ya da Sum olabilir.
Daha önce bahsedilen (1 + 2) + 4 expression’ını saklamak için, Expr object’lerinden oluşan bir structure oluşturursun;
özellikle Sum(Sum(Num(1), Num(2)), Num(4)). img_3.png bunu gösterir. Amacın, Sum ve Num object’lerinden oluşan bu tür
expression’ları evaluate ederek ortaya çıkan value’yu hesaplamak. Şimdi buna bakalım. Expr interface’ının iki
implementasyonu vardır, dolayısıyla bir expression için result value’yu evaluate etmek için iki seçeneği denemen
gerekir: Bir expression bir number ise, karşılık gelen value’yu return edersin. Eğer bir sum ise, left ve right
expression’ları recursive olarak evaluate etmeli ve onların sum’ını return etmelisin. */

/* Önce, bu function’ın Java code’unda görebileceğine benzer bir style’da yazılmış bir implementasyonuna bakacağız.
Ardından, bunu idiomatic Kotlin’i yansıtacak şekilde refactor edeceğiz. Başlangıçta, diğer dillerde görebileceğin
style’a benzeyen, Expr’ın farklı subtype’larını kontrol etmek için bir dizi if expression kullanan bir function
yazabilirsin. Kotlin’de, bir variable’ın belirli bir type olup olmadığını **is** kontrolüyle denersin; dolayısıyla bir
implementasyon aşağıdaki gibi görünebilir. */

fun eval236(e: Expr236): Int {
    if (e is Num236) {
        val n = e as Num236
        return n.value
    }
    if (e is Sum236) {
        /* Variable **e** smart cast edilir. */
        return eval236(e.left) + eval236(e.right)
    }
    throw IllegalArgumentException("unknown expression")
}

fun main() {
    // Bizden istenen (1 + 2) + 4
    val eval236 = eval236(
        Sum236(
            Sum236(Num236(1), Num236(2)),
            Num236(4)
        )
    )
    println(eval236)
}

/* C# ile programladıysan **is** syntax’ı sana tanıdık gelebilir ve Java geliştiricileri bunu **instanceof** karşılığı
olarak tanıyabilir. Kotlin’in **is** kontrolü ek bir kolaylık sağlar: Bir variable’ı belirli bir type için kontrol
edersen, sonrasında cast yapman gerekmez; onu kontrol ettiğin type olarak kullanabilirsin. Etkili bir şekilde, compiler
senin için cast işlemini gerçekleştirir; buna smart cast denir. eval function’ında, variable e’nin Num type’ında olup
olmadığını kontrol ettikten sonra, compiler onu akıllıca Num type’ında bir variable olarak yorumlar. Böylece explicit
bir cast yapmana gerek kalmadan Num’un value property’sine erişebilirsin: e.value. Aynısı Sum’ın right ve left
property’leri için de geçerlidir: ilgili context’te yalnızca e.right ve e.left yazarsın. Smart cast, yalnızca bir
variable **is** kontrolünden sonra değişmiş olamayacaksa çalışır. Bir class’ın property’siyle smart cast kullanıyorsan,
bu örnekte olduğu gibi, property’nin bir val olması ve custom bir accessor’a sahip olmaması gerekir. Aksi durumda,
property’e yapılan her erişimin aynı value’yu döndüreceğini doğrulamak mümkün olmaz. Daha sonra göreceğin üzere,
smart cast’ler Kotlin’in diğer language feature’larıyla da birlikte çalışır; örneğin nullability ve Kotlin’in varsayılan
olarak final olan class’ları. Belirli bir type’a explicit cast, **as** keyword'u ile ifade edilir: Ama tahmin etmiş
olabileceğin gibi, bu implementasyon henüz idiomatic Kotlin olarak kabul edilmez. Şimdi eval function’ını nasıl refactor
edeceğimize bakalım. */