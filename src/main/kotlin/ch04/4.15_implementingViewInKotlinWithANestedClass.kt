package ch04

class Button : View{
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state : State) {}

    /* Bu class, Java’daki static nested class’ın bir karşılığıdır. */
    class ButtonState : State
}

/* Kotlin’de explicit bir modifier olmayan bir nested class, Java’daki static nested class ile aynıdır. Bunu, outer
class’a bir referans içermesi için inner class’a çevirmek istiyorsan, inner modifier’ını kullanırsın.
*/

/* img.png dosyasına bakalım */

/* Nested class’lar outer class’a referans tutmaz, oysa inner class’lar tutar. Kotlin’de bir outer class instance’ına
referans verme syntax'ı da Java’dan farklıdır. Inner class’tan Outer class’a erişmek için this@Outer yazarsın:
*/

class Outer{
    inner class Inner{
        fun getOuterReference() : Outer = this@Outer
    }
}