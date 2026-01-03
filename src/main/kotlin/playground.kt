fun main() {
    buildFunctionExample()
}

fun buildFunctionExample() {
    val fibonacci = buildList {
        addAll(listOf(1, 1, 2))
        add(3)
        add(index = 0, element = 3)
    }

    println(fibonacci) // [3, 1, 1, 2, 3]

    val shouldAdd = true
    val fruits = buildSet {
        add("apple")
        if (shouldAdd) {
            addAll(
                listOf(
                    "apple",
                    "banana",
                    "cherry"
                )
            )
        }
    }
    println(fruits) // [apple, banana, cherry]

    val medals = buildMap {
        put(1, "Gold")
        putAll(listOf(
            2 to "Silver",
            3 to "Bronze"
        ))
    }
    println(medals) // {1=Gold, 2=Silver, 3=Bronze}
}

