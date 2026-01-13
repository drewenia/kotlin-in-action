import java.time.LocalDate

class DatabaseManager{
    val databaseQuery : String by lazy{
        println("Database connection...")
        "CONNECTION_ESTABLISHED"
    }
}

fun main() {
    val dbManager = DatabaseManager()

    println(dbManager.databaseQuery)
    // Database connection...
    // CONNECTION_ESTABLISHED

    println(dbManager.databaseQuery)
    // CONNECTION_ESTABLISHED
}