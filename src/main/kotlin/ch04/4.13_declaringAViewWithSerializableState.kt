package ch04

import java.io.Serializable

/* Bir helper class’ı encapsulate etmek veya kodu kullanıldığı yere yakın tutmak istiyorsan, bir class’ı başka bir
class’ın içinde declare edebilirsin. Ancak Java’nın aksine, Kotlin’de nested class’lar outer class instance’ına, bunu
özellikle talep etmedikçe erişemez. Bunun neden önemli olduğunu gösteren bir örneğe bakalım.
*/

interface State : Serializable

interface View {
    fun getCurrentState() : State
    fun restoreState(state : State)
}

/* Button state’ini kaydeden bir class’ı Button class’ında tanımlamak kullanışlıdır. Java’da bunun nasıl
yapılabileceğine bakalım (benzer Kotlin kodu kısa süre içinde gösterilecektir).
*/

/* Java */
/*
public class Button implements View {

    @Override
    public State getCurrentState() {
        return new ButtonState();
    }

    @Override
    public void restoreState(State state) {
    }

    public class ButtonState implements State {
    }
}*/

/* Button için özel bilgiler tutan ve State interface’ini implement eden ButtonState class’ını tanımlarsın.
getCurrentState method’unda bu class’ın yeni bir instance’ını oluşturursun. Gerçek bir state'de, ButtonState’i tüm
gerekli verilerle initialize edersin. Bu kodda ne yanlış? Eğer declare edilmiş button’ın state’ini serialize etmeye
çalışırsan neden java.io.NotSerializableException: Button hatası alırsın? İlk bakışta garip görünebilir: serialize
ettiğin variable Button type değil, ButtonState type’ındadır. Java’da bir class’ı başka bir class içinde declare
ettiğinde, varsayılan olarak inner class olur. Örnekteki ButtonState class’ı, dışındaki Button class’a implicit bir
referans tutar. Bu, ButtonState’in serialize edilememesini açıklar: Button serializable değildir ve ona olan referans
ButtonState’in serialization’ını bozar. Bu sorunu çözmek için ButtonState class’ını static olarak declare etmen gerekir.
Bir nested class’ı static olarak declare etmek, o class’ın enclosing class’a olan implicit referansını kaldırır.
Kotlin’de inner class’ların varsayılan davranışı, az önce anlattığımızın tersidir.

4.15_implementingViewInKotlinWithANestedClass dosyasından devam edelim
*/
