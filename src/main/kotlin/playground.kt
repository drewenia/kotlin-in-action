import ch04.Person441v2
import java.io.File

fun main() {

}

interface IdGenerator{
    fun generate() : Int
}

object RandomIdGenerator : IdGenerator {
    override fun generate() = (0..1000).random()
}
