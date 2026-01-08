fun main() {

}

class StringPrinter : StringProcessor {
    override fun process(value: String){
        println(value)
    }
}

class NullableStringPrinter : StringProcessor {
    override fun process(value : String?){
        if (value!=null) println(value)
    }
}



// data class Person(val name: String, val age: Int)

