package ch02

enum class Shape(){
    RECTANGLE;

    fun calculateArea(width : Int,height:Int, shape : Shape) : Int{
        return if(shape.name == "RECTANGLE"){
            width * height
        } else {
            0
        }
    }
}

fun main(){
    val area = Shape.RECTANGLE.calculateArea(11,23,Shape.RECTANGLE)
    print(area)
}