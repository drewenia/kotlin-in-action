import java.io.Serializable

fun main() {
    val toggleable : Toggleable = LightSwitch()
    toggleable.toggle() // Lights
}

sealed interface Toggleable{
    fun toggle()
}

class LightSwitch : Toggleable {
    override fun toggle() = println("Lights")
}

class Camera : Toggleable {
    override fun toggle() = println("Camera")
}
