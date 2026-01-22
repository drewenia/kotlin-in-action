open class Animal
class Cat : Animal()

/* enumerateCats şunu şart koşuyor: "Bana bir fonksiyon ver, bu fonksiyon bir Cat alsın ve bana bir Number versin."
Tipi: (Cat) -> Number */
fun enumerateCats(f: (Cat) -> Number){
    val myCat = Cat()
    val result = f(myCat)
    println("$result")
}

// Girdi: Bir Animal nesnesi. Çıktı bir int değeri. sembolik olarak 42 yazdım
// Yani bu fonksiyonun tipi aslında şudur: (Animal) -> Int.
fun Animal.getIndex() : Int = 42

fun main(){
    enumerateCats (Animal::getIndex)
}