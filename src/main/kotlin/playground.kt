enum class OS {
    WINDOWS,
    LINUX,
    MACOS,
    IOS,
    ANDROID
}

data class SiteVisit(
    val path: String,
    val duration: Double,
    val os: OS
)

val log = listOf(
    SiteVisit("/", 34.0, OS.WINDOWS),
    SiteVisit("/", 22.0, OS.MACOS),
    SiteVisit("/login", 12.0, OS.WINDOWS),
    SiteVisit("/signup", 8.0, OS.IOS),
    SiteVisit("/", 16.3, OS.ANDROID)
)

fun List<SiteVisit>.averageDurationFor(predicate : (SiteVisit) -> Boolean) =
    filter(predicate).map(SiteVisit::duration).average()


fun main() {
    val averageDuration = log.averageDurationFor { it.os == OS.IOS && it.path == "/signup" }
    println(averageDuration) // 8.0
}