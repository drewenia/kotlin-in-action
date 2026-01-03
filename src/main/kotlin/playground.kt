fun main() {
    print(alphabet())
    // abcdefghijklmnopqrstuvwxyz
}

fun alphabet() : String = with(StringBuilder()){
    for (letter in 'a'..'z'){
        append(letter)
    }
    toString()
}

