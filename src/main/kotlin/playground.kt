fun main() {
    downToExample()
}

fun downToExample(){
    for (i in 100 downTo 1 step 2){
        println(i) // 100 98 96 94 92 90 ... 2
    }
}