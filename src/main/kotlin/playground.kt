fun main() {
    val path = "/Users/yole/kotlin-book/chapter.adoc"
    parsePath(path)
}

fun parsePath(path : String){
    val regex ="""(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null){
        val(directory,filename,extension) = matchResult.destructured
        println("Dir : $directory, name : $filename, extension : $extension")
        // Dir: /Users/yole/kotlin-book, name: chapter, ext: adoc
    }
}