package ch04


/*    MODIFIER              CLASS MEMBER              TOP-LEVEL DECLARATION
    public (default)    -> Visible everywhere       -> Visible everywhere
    internal            -> Visible in a module      -> Visible in a module
    protected           -> Visible in subclasses
    private             -> Visible in a class       -> Visible in a file
*/

internal open class TalkativeButton{
    private fun yell() = println("hey!")
    protected fun whisper() = println("lets a talk")
}

/* Error: public member internal receiver type TalkativeButton ı expose eder hatadır
fun TalkativeButton.giveSpeech(){
    yell()

    // Hata: whisper'a erişilemiyor; TalkativeButton içinde protected.
    whisper()
}*/

/* Kotlin, public olan giveSpeech fonksiyonundan daha az görünürlüğe sahip olan (bu durumda internal) TalkativeButton
type'ına referans vermeni yasaklar. Bu, daha genel bir kuralın bir örneğidir: bir class'ın veya bir method'un base
types listesindeki ve type parameters içindeki tüm types'lar ya da bir method'un imzasında kullanılan tüm types'lar,
class veya method’un kendisi kadar görünür olmalıdır. Bu kural, fonksiyonu invoke etmek veya bir class'ı extend etmek
için ihtiyaç duyabileceğin tüm types'lara her zaman erişimin olmasını sağlar. Sorunu çözmek için giveSpeech extension
function'ı internal yapabilir veya TalkativeButton class'ını public hale getirebilirsin. Java ve Kotlin’de protected
değiştiricisinin davranışındaki farka dikkat et. Java’da, aynı package içinden protected bir üyeye erişebilirsin, ancak
Kotlin buna izin vermez. Kotlin’de görünürlük kuralları basittir ve protected bir üye yalnızca class içinde ve onun
subclasses içinde görünür. Ayrıca bir class’ın extension functions’larının onun private veya protected üyelerine
erişemediğini de unutma. Bu nedenle extension function giveSpeech içinden protected whisper function’ını çağıramazsın.
*/

/*Kotlin’de public, protected ve private değiştiricileri Java bytecode’a derlenirken korunur. Bu tür Kotlin
declaration’larını Java kodundan, sanki Java’da aynı visibility ile declare edilmiş gibi kullanırsın. Tek istisna
private bir class’tır: Java’da bir class’ı private yapamayacağın için, perde arkasında package-private bir declaration
olarak derlenir. Peki internal modifier’ı ne olur? Java’da bunun doğrudan bir karşılığı yoktur. Package-private
visibility tamamen farklıdır: bir module genellikle birkaç package içerir ve farklı modules aynı package’tan
declarations içerebilir. Bu nedenle internal modifier bytecode’da public olur. Kotlin declaration’larıyla Java’daki
benzerleri (veya bytecode’daki temsilleri) arasındaki bu ilişki, bazen Kotlin’den erişemediğin bir şeye Java kodundan
erişebilmenin nedenini açıklar. Örneğin başka bir module içindeki Java kodundan bir internal class’a veya top-level bir
declaration’a ya da aynı package içindeki Java kodundan protected bir member’a erişebilirsin. Ancak bir class’ın
internal members’larının adlarının değiştirildiğini unutma. Teknik olarak internal members Java’dan kullanılabilir,
fakat Java kodunda çirkin görünürler. Bu, başka bir module’den bir class’ı extend ettiğinde override’larda beklenmedik
çakışmaların önlenmesine yardımcı olur ve içsel olarak internal class’ları yanlışlıkla kullanmanı engeller.
*/

/* Kotlin ve Java arasındaki görünürlük kurallarındaki bir başka fark, Kotlin’de bir outer class’ın inner (veya nested)
class’larının private members’larını görememesidir.*/
