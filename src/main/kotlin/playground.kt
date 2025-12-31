fun main() {
    var clickCount = 0
    Button(object : MouseListener{
        override fun onEnter() {
            TODO("Not yet implemented")
        }

        override fun onClick() {
            clickCount++
        }
    })
}

interface MouseListener {
    fun onEnter()
    fun onClick()
}

class Button(private val listener: MouseListener)

