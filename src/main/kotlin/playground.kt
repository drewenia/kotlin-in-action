fun main() {
    val button = Button()

    button.showOff()
    // I am clickable
    // I am focusable

    button.setFocus(false)
    // I lost focus
}

interface Clickable {
    fun click()
    fun showOff() = println("I am clickable")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus")
    fun showOff() = println("I am focusable")
}

class Button : Clickable, Focusable {
    override fun click() = println("I was clicked")
    /* Aynı member için birden fazla implementation inherit ediliyorsa, açık bir implementation sağlamanız gerekir. */
    override fun showOff() {
        /* Burada, angle brackets içindeki supertype adıyla nitelendirilen super, call etmek istediğiniz method’un hangi
        parent’a ait olduğunu belirtir. */
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}