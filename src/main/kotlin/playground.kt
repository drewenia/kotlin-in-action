import java.lang.reflect.Type
import kotlin.properties.Delegates

class C {
    var prop : Type by MyDelegate()
}

val c = C

fun main() {

}

