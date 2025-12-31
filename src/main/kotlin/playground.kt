import kotlin.math.exp

fun main() {
    transfer(UserId(5), UserId(4), Amount(100))
}

@JvmInline
value class UserId(val value: Int)

@JvmInline
value class Amount(val amount: Int)

fun transfer(from: UserId, to: UserId, amount: Amount) {}


interface MouseListener {
    fun onEnter()
    fun onClick()
}

class Button(private val listener: MouseListener)
