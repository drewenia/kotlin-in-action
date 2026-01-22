open class Mammal(val name: String) {
    fun eat() {}
    fun sleep() {}
}

data class Sloth(val slothName: String, val isTwoFingered: Boolean) : Mammal(slothName)

data class Panda(val pandaName: String) : Mammal(pandaName)

fun main() {
    // Burada ki list compiler tarafından infer edildiğinde List<Mammal> olur
    val crewList = listOf(
        Sloth("Jerry", false),
        Sloth("Bae", true),
        Sloth("Chrissy", false),
        Panda("Jay"),
        Panda("Peggy")
    )

    val compareByNames = Comparator{a : Mammal, b: Mammal ->
        a.name.first().code - b.name.first().code
    }

    println(crewList.sortedWith(compareByNames))
    /* [Sloth(slothName=Bae, isTwoFingered=true), Sloth(slothName=Chrissy, isTwoFingered=false),
    Sloth(slothName=Jerry, isTwoFingered=false), Panda(pandaName=Jay), Panda(pandaName=Peggy)]*/
}