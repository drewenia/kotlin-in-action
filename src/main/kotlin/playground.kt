import java.io.File

fun saveConfig(config : String){
    File("config.txt").bufferedWriter().use{writer ->
        writer.write(config)
    }
}
fun main() {
    saveConfig("Theme=Dark\nFontSize=14")
    println("Config saved successfully.")
}