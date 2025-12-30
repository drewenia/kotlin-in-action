import java.net.URI

fun main() {

}

open class Downloader {
    constructor(url : String?){
        // some code
    }

    constructor(uri : URI?){
        // some code
    }
}

class MyDownloader : Downloader {
    // this Class’ın başka bir constructor’ına delegation yapar
    constructor(url : String?) : this(URI(url))
    constructor(uri : URI?) : super(uri)
}

