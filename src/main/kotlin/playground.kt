class WeatherStation{
    lateinit var latestReading : String

    fun printReading(){
        if (this::latestReading.isInitialized){
            println("Latest reading : $latestReading")
        } else {
            println("No reading available")
        }
    }
}

fun main() {
    val ws = WeatherStation()

    ws.printReading() // No reading available
    ws.latestReading = "22°C, sunny"
    ws.printReading() // Latest reading : 22°C, sunny
}


// data class Person(val name: String, val age: Int)

