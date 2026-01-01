
fun main() {

}

class Button{
    fun onClick() = println("click")
}

fun tryToCountButtonClicks(button : Button) : Int{
    var clicks = 0
    button.onClick() {clicks++}
    return clicks
}



