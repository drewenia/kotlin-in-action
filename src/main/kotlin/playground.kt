import java.security.Provider
import java.util.ServiceLoader


inline fun <reified T : Any> getService(filter: (T) -> Boolean): T? {
    return ServiceLoader.load(T::class.java).find(filter)
}

fun main() {
    getService<FileCompressor> {it.extension == "rar"}?.compress("Document.pdf")
}