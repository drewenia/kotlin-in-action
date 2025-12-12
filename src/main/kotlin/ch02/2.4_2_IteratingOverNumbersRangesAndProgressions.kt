package ch02

/* Kotlin’de C-style for loop yoktur; bir variable’ı initialize edip, her adımda value’sunu update ettiğin ve value
belirli bir bound’a ulaştığında loop’tan çıktığın klasik yapı (int i = 0; i < 10; i++). Bu tür loop’ların en yaygın
kullanım senaryolarını karşılamak için Kotlin, range kavramını kullanır. Bir range, temel olarak iki value arasındaki
bir interval’dir; genellikle number’lar: bir start ve bir end. Bunu .. operator’ü ile yazarsın. */

val oneToTen = 1..10

/* Kotlin’de bu range’lerin closed ya da inclusive olduğunu, yani ikinci value’nun her zaman range’in bir parçası
olduğunu unutma. Integer range’leriyle yapabileceğin en temel şey, tüm value’lar üzerinde loop yapmaktır. Bir range’in
tüm value’ları üzerinde iterate edebiliyorsan, böyle bir range’e progression denir.

Hadi integer range’leri kullanarak Fizz-Buzz oyunu oynayalım. Bu, uzun bir araba yolculuğunda hayatta kalmanın ve
unutulmuş division becerilerini hatırlamanın güzel bir yoludur. Bu oyunu implement etmek, programlama mülakatlarında da
popüler bir task’tır! Fizz-Buzz oynamak için oyuncular sırayla artan şekilde sayar ve 3’e bölünebilen herhangi bir
number’ı fizz, 5’e bölünebilen herhangi bir number’ı buzz ile değiştirir. Bir number hem 3 hem de 5’in multiple’ıysa,
“Fizz-Buzz” dersin. Aşağıdaki code, 1’den 100’e kadar olan number’lar için doğru cevapları print eder. Dikkat edersen,
olası koşulları argümansız bir when expression ile kontrol ediyorsun.  */

fun fizzBuzz242(i : Int) = when{
    i % 15 == 0 -> "Fizzbuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i"
}

fun main() {
    // 1 ile 100 arasını iterate et
    for(i in 1..100){
        print(fizzBuzz242(i))
    }

    println()

    /* 100’den geriye doğru saymaya başlayalım ve yalnızca çift (even) sayıları dahil edelim. Şimdi, bazı sayıları
    atlamasına izin veren bir step’e sahip bir progression üzerinde iteration yapıyorsun. Step negatif de olabilir,
    bu durumda progression ileri yerine geri gider. Bu örnekte, 100 downTo 1, geriye doğru giden bir progression’dır
    (step –1 ile). Ardından step, yönü koruyarak step’in absolute değerini 2 olarak değiştirir (etkili olarak step’i
    –2 olarak ayarlar). */
    for(i in 100 downTo 1 step 2){
        print(fizzBuzz242(i))
    }
}

/* Daha önce bahsettiğimiz gibi, .. syntax’ı her zaman end point’i (..’un sağındaki value) içeren bir range oluşturur.
Birçok durumda, belirtilen end point’i içermeyen half-closed range’ler üzerinde iteration yapmak daha kullanışlıdır.
Böyle bir range oluşturmak için ..< kullan. Örneğin, for (x in 0..<size) döngüsü, for (x in 0..size-1) ile eşdeğerdir,
ancak fikri biraz daha açık ifade eder. */