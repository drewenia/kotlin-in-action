import java.io.Serializable

fun main() {
    val button = Button()
    button.text = "OK"
    button.enabled = false

    val savedState = button.getCurrentState()

    // state bozuluyor
    button.text = "Cancel"
    button.enabled = true

    // geri yükleme
    button.restoreState(savedState)

    println(button.text) // OK
    println(button.enabled) // false
}

interface State : Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State)
}

class Button : View {
    var text: String = ""
    var enabled: Boolean = true
    override fun getCurrentState(): State = ButtonState(text, enabled)

    override fun restoreState(state: State) {
        // buradaki as Gelen State’i ButtonState olarak daraltır. Çünkü sadece Button kendi state’ini anlayabilir
        val buttonState = state as ButtonState
        text = buttonState.text
        enabled = buttonState.enabled
    }

    // State = o anki durumun kopyası
    class ButtonState(val text: String, val enabled: Boolean) : State
}
