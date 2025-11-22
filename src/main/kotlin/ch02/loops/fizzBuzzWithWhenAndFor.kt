package ch02.loops

fun fizzBuzzWithWhen(i : Int) = when{
    i % 15 == 0 -> "fizzbuzz "
    i % 3 == 0 -> "fizz "
    i % 5 == 0 -> "buzz "
    else -> "$i "
}

fun main(){
    // 1 den 100 e kadar
    for (i in 1..100){
        print(fizzBuzzWithWhen(i))
    }

    // 100 den geriye 2'şerli düşerek yani çift sayılar
    for (i in 100 downTo 1 step 2){
        print(fizzBuzzWithWhen(i))
    }
}