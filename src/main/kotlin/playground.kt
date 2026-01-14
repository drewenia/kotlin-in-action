import java.lang.reflect.Type
import kotlin.properties.Delegates

class Population(var cities : Map<String,Int>){
    val sanFrancisco by cities
    val tallinn by cities
    val kotlin by cities
}

val population = Population(
    mapOf(
        "sanFrancisco" to 864_716,
        "tallinn" to 413_782,
        "kotlin" to 43_005
    )
)

fun main() {
    println(population.sanFrancisco) // 864716
}

