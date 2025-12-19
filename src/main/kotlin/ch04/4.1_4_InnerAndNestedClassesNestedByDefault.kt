package ch04

import java.io.Serializable

/* Bir helper class’ı encapsulate etmek ya da code’u kullanıldığı yere yakın tutmak istiyorsanız, bir class’ı başka bir
class’ın içinde declare edebilirsiniz. Ancak Java’dan farklı olarak, Kotlin’de nested class’lar, siz özellikle talep
etmedikçe outer class instance’ına erişime sahip değildir. Bunun neden önemli olduğunu gösteren bir örneğe bakalım. */

interface State414 : Serializable

interface View414 {
    fun getCurrentState(): State414
    fun restoreState(state : State414) {}
}

/* Button class’ı içinde bir button state’ini kaydeden bir class tanımlamak kullanışlıdır. Bunun Java’da nasıl
yapılabileceğine bakalım (java/ch04 package'i içerisine button'u örnek olarak yerleştiriyorum Button414Java.java) */

/*
public class Button414Java implements View414{
    @Override
    public State414 getCurrentState() {
        return new ButtonState();
    }

    @Override
    public void restoreState(State414 state) {}

    public class ButtonState implements State414{}
}
*/

/* State interface’ini implement eden ve Button’a özgü bilgileri tutan ButtonState class’ını tanımlarsınız.
getCurrentState method’unda bu class’ın yeni bir instance’ını oluşturursunuz. Gerçek bir case'de, ButtonState’i gerekli
tüm data ile initialize ederdiniz. Bu code’da sorun nedir? Tanımlanan button’ın state’ini serialize etmeye
çalıştığınızda neden java.io.NotSerializableException: Button exception’ı alırsınız? İlk bakışta bu garip görünebilir:
serialize ettiğiniz variable, Button type’ında değil, ButtonState type’ındadır. Java’da bir class’ı başka bir class’ın
içinde declare ettiğinizde, varsayılan olarak inner class hâline geldiğini hatırladığınızda her şey netleşir. Örnekteki
ButtonState class’ı, outer Button class’ına bir referansı implicit olarak saklar. ButtonState’in serialize
edilememesinin nedeni de budur: Button serializable değildir ve ona olan bu referans, ButtonState’in serialization’ını
bozar. Bu problemi düzeltmek için, ButtonState class’ını static olarak declare etmeniz gerekir. Bir nested class’ı
static olarak declare etmek, o class’tan enclosing class’a olan implicit referansı kaldırır. Kotlin’de ise inner
class’ların varsayılan davranışı, az önce tanımladığımızın tersidir; bu durum aşağıda gösterilmiştir. */

class Button414 : View414{
    override fun getCurrentState(): State414 = ButtonState()
    override fun restoreState(state : State414) {}
    class ButtonState : State414 {}
}

/* Kotlin’de herhangi bir explicit modifier olmadan tanımlanan bir nested class, Java’daki static nested class ile
aynıdır. Onu, outer class’a bir referans içerecek şekilde inner class’a dönüştürmek için inner modifier’ını
kullanırsınız. img_2.png, Java ve Kotlin arasındaki bu davranış farklarını açıklar ve nested ile inner class’lar
arasındaki fark, img_03.png’de gösterilmiştir. Kotlin’de outer bir class’ın instance’ına referans verme syntax’ı da
Java’dan farklıdır. Inner class içinden Outer class’a erişmek için this@Outer yazarsınız: */

class Outer414 {
    inner class Inner414 {
        fun getOuterClassReference() : Outer414 = this@Outer414
    }
}

/* Artık Java ve Kotlin’de inner ve nested class’lar arasındaki farkı öğrendiniz. Şimdi, sınırlı sayıda class içeren
bir hierarchy’nin nasıl oluşturulacağını ele alalım. */