package ch02

/* Fonksiyonların amacı çoğu zaman bir şey hesaplamak ve ardından bir tür sonuç döndürmektir. Örneğin, iki integer sayı
olan a ve b’yi alan ve ikisinden büyük olanı döndüren basit bir max fonksiyonu yazmak isteyebilirsiniz. Peki bu nasıl
görünürdü? Fonksiyon declaration’ı, fun anahtar kelimesiyle başlar ve ardından fonksiyon adı gelir: bu durumda max.
Bunun ardından parantez içindeki parameter listesi gelir. Burada, her ikisi de Int type’ında olan iki parameter declare
ediyoruz: a ve b. Kotlin’de önce parameter adını, ardından iki nokta ile ayrılmış şekilde type’ını belirtirsiniz.
Return type ise parameter listesinden sonra gelir ve ondan bir colon ile ayrılır: Kotlin’de if’in bir result value
üreten bir expression olduğunu unutmayın. if’i, branch'lerinin birinden bir value döndüren bir yapı olarak
düşünebilirsiniz. */

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun isEven(a: Int): Boolean {
    return a % 2 == 0
}


/* Her Kotlin programının entry point’i main fonksiyonudur. Bu fonksiyon ya hiçbir parameter olmadan ya da bir string
array’ini argüman olarak alacak şekilde declare edilebilir (args: Array<String>). İkinci durumda, array içindeki her
element uygulamanıza iletilen bir komut satırı parameter’ına karşılık gelir. Her iki durumda da main fonksiyonu
herhangi bir value döndürmez. */

fun main(){
    val maxValue = max(11,22)
    val valueIsEven = isEven(maxValue)

    // aşağıda ki açıklamaya örnek olması için yazıldı
    val x = if (isEven(11)) 3 else 5
    println(x) // 5

    // aşağıda ki açıklamaya örnek olması için yazıldı
    val inputString = "u"
    val direction = when(inputString) {
        "u" -> "UP"
        "d" -> "DOWN"
        else -> "UNKNOWN"
    }
    println(direction) // UP

    // aşağıda ki açıklamaya örnek olması için yazıldı
    val number = try {
        inputString.toInt()
    } catch(nfe : NumberFormatException) {
        -1
    }
    println(number) // -1
}

/* Kotlin’de if bir statement değil, bir expression’dır. Expression ile statement arasındaki fark, bir expression’ın
bir value’ya sahip olması ve başka bir expression’ın parçası olarak kullanılabilmesidir; oysa bir statement her zaman
enclosing block’un top-level bir element’idir ve kendi value’su yoktur. Kotlin’de, loop’lar (for, while ve do/while)
dışında çoğu control structure bir expression’dır ve bu yönüyle Java gibi diğer dillerden ayrılır. Özellikle,
control structure’ları diğer expression’larla birleştirebilme özelliği, birçok yaygın pattern’i kısa biçimde ifade
etmenizi sağlar. Kotlin’de geçerli olan bazı kod parçaları şunlardır (main methodunda örneklendi):
*/

/* Kotlin assignment’ların her zaman statement olmasını zorunlu kılar — yani bir variable’a value atarken, bu assignment
operation’ı kendi başına bir value döndürmez. Bu durum, assignment ve comparison arasındaki karışıklığı önlemeye
yardımcı olur; çünkü bunların expression olarak ele alındığı Java veya C/C++ gibi dillerde bu karışıklık yaygın bir
hata kaynağıdır. */

/* JAVA
    int x;
    /* Assignment bir value üretir. Yani şu kod hem atama yapar, hem de value döndürür:
    * x’e 5 değerini assign eder.
    * Bu assignment’ın sonucu 5’tir, yani if içinde evaluation devam eder.
    * (x = 5) == 5 → true olur.
    */
    if ((x = 5) == 8) {
        System.out.println("Yes"); // Yes
    }

    boolean flag = false;

    if (flag = true) {
        // buraya girer!
    }
*/

/* Kotlin: Assignment bir statement’tır (expression değildir) Kotlin bu hataları tamamen engellemek için assignment’ı
statement yapmıştır:*/

fun test(){
    var x = 5
    x = 7 // sadece statement — value döndürmez
    /*
    Kotlin bu kullanıma izin vermez
    var y : Int
    if((y = 5) == 5){
    }
    */
}

/*

Expression, bir değer üreten her şeydir. Ne yazarsan yaz, eğer onun sonucu bir değerse → o bir expression’dır.
Expression her zaman bir değer döndürür.

- 3 + 5 → sonucu 8

- "hello".length → sonucu 5

- x * 2 → x’e göre bir değer üretir

- true || false → sonucu true

- getUser() → bir değer döndürdüğü için expression’dır

- flag == true → boolean değer döndürür

Statement, bir iş yapan ama bir değer döndürmeyen koddur.

- print("Hello") → sadece yazdırır, değer döndürmez

- return → bir iş yapar

- while (...) { ... } → bir süreç başlatır

- var x = 10 (Kotlin’de variable declare eden satır)

- x = 20 (Kotlin’de assignment)

Assignment, bir variable’a değer verme işlemidir.

- x = 5

x'in value’su 5 yapılır. Ama bu işlem bir değer döndürmez (Kotlin’de). Java/C/C++’ta assignment aynı anda expression
olduğu için bir değer döndürür, bu da karışıklık yaratır.
*/



