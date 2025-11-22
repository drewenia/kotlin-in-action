package ch02.getter

/*
Sadece width, height'a eşit ise boolean bir değer döndürür ve hemen compute edilir
*/
class Rectangle(val width: Int, val height: Int) {
    val isSquare : Boolean
        get(){
            return width == height
        }
}

fun main(){
    val rectangle = Rectangle(41,32)
    println(rectangle.isSquare)
}