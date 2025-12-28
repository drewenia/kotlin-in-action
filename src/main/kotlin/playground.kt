fun main() {
    val view : View = Button()
    view.showoff() // I am a view
}

open class View {
    open fun click() = println("View clicked")
}

class Button : View(){
    override fun click() = println("Button clicked")
}

fun View.showoff() = println("I am a view")
fun Button.showOff() = println("I am a button")