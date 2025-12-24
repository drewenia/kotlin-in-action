package ch05

import java.awt.Button

/* Bir function içinde anonymous inner class declare ettiğinizde, o function’ın parameter’larına ve local
variable’larına class’ın içinden referans verebildiğinizi biliyorsunuz. Lambdas ile de tam olarak aynı şeyi
yapabilirsiniz. Bir function içinde bir lambda kullanırsanız, o function’ın parameter’larına ve lambda’dan önce declare
edilmiş local variable’lara erişebilirsiniz (img_1.png'ye bakın). Göstermek için forEach standard library function’ını
kullanalım. Bu, en temel collection-manipulation functions’lardan biridir; yaptığı tek şey, verilen lambda’yı
collection’daki her element üzerinde call etmektir. forEach function’ı, normal bir for loop’a göre biraz daha kısadır,
ancak çok fazla başka avantajı yoktur; bu yüzden tüm loop’larınızı lambdas’a dönüştürmek için acele etmenize gerek
yoktur. Aşağıdaki code, bir messages list’ini alır ve her birini aynı prefix ile yazdırır. */

fun printMessagesWithPrefix514 (messages : Collection<String>, prefix : String){
    // Her element ile ne yapılacağını belirten bir lambda’yı argument olarak alır
    messages.forEach{
        // Lambda içinde prefix parameter’ına erişir
        println("$prefix $it")
    }
}
/* forEach lambda’sı, surrounding (çevreleyen) scope’ta tanımlı prefix variable’ına ve surrounding scope’larda tanımlı
diğer tüm variable’lara — surrounding class ve file scope’larına kadar — erişebilir. Kotlin ve Java arasında lambdas
kullanımındaki önemli farklardan biri şudur: Kotlin’de final variable’lara erişimle sınırlı değilsiniz; bir lambda’nın
içinden variable’ları modify da edebilirsiniz. Bir sonraki code’da, verilen bir response status codes collection’ında
client ve server errors sayısını sayıyorsunuz. Bunu, printProblemCounts function’ı içinde tanımlanmış clientErrors ve
serverErrors variable’larını forEach lambda’sının içinden increment ederek yaparsınız. */

fun printProblemCounts514(responses : Collection<String>){
    /* Lambda içinden erişilecek variable’ları declare eder */
    var clientErrors = 0
    var serverErrors = 0
    responses.forEach {
        // Lambda içinde variable’ları modify eder
        if (it.startsWith("4")) clientErrors++
        else if(it.startsWith("5")) serverErrors++
    }
    println("$clientErrors client errors, $serverErrors server errors") // 1 client errors, 1 server errors
}

/* Gördüğünüz gibi, Kotlin bir lambda içinde nonfinal variable’lara erişmenize (ve onları modify etmenize) izin verir.
Bu örneklerde prefix, clientErrors ve serverErrors gibi bir lambda içinden erişilen external variable’ların lambda
tarafından capture edildiği söylenir. Varsayılan olarak, bir local variable’ın lifetime’ı, variable’ın declare edildiği
function ile sınırlıdır. Ancak bir lambda tarafından capture edilirse, bu variable’ı kullanan code saklanabilir ve daha
sonra execute edilebilir. Bunun nasıl çalıştığını merak edebilirsiniz. Bir final variable capture edildiğinde, onun
value’su, onu kullanan lambda code’u ile birlikte saklanır. Nonfinal variable’lar için ise, value özel bir wrapper içine
alınır; bu wrapper onu değiştirmenize izin verir ve wrapper’a olan reference lambda ile birlikte saklanır. */

/* Mutable bir variable’ı capture etme: Implementation detayları

Java yalnızca final variable’ların capture edilmesine izin verir. Mutable bir variable’ı capture etmek istediğinizde,
şu hilelerden birini kullanabilirsiniz: ya mutable value’yu saklamak için tek element’li bir array declare edersiniz
ya da mutable reference’ı saklayan bir wrapper class’ın bir instance’ını oluşturursunuz. Bu tekniği Kotlin’de explicit
olarak kullansaydınız, code aşağıdaki gibi olurdu:
*/

// Değiştirilebilir bir variable’ı capture etmeyi simüle etmek için kullanılan class
class Ref514<T>(var value : T)

fun changeVariable514(){
    val counter = Ref514(0)
    /* Formal olarak, immutable bir variable captured edilir, ancak actual value bir field içinde stored edilir ve
    değiştirilebilir. */
    val increment = {counter.value++}
}

/* Gerçek kodda, bu tür wrapper’lar oluşturman gerekmez. Bunun yerine, variable’ı doğrudan mutate edebilirsin. */

fun changeVariable514v2(){
    var counter = 0
    val increment = {counter++}
}

/* Nasıl çalışır? İlk example, ikinci example’ın under the hood nasıl çalıştığını gösterir. Bir final variable (val)
capture ettiğin her durumda, Java’daki gibi value’su kopyalanır. Mutable bir variable (var) capture ettiğinde ise,
value’su bir Ref class’ının instance’ı olarak stored edilir. Ref variable final’dır ve kolayca capture edilebilir; buna
karşılık actual value bir field içinde stored edilir ve lambda içinden değiştirilebilir. */

/* Önemli bir caveat şudur: Eğer bir lambda bir event handler olarak kullanılırsa ya da başka bir şekilde asynchronous
olarak executed edilirse, local variable’lara yapılan modification’lar yalnızca lambda executed edildiğinde gerçekleşir.
Örneğin, aşağıdaki kod button click’lerini saymak için doğru bir yol değildir: */

/*fun tryToCountButtonClicks(button : Button) : Int {
    var clicks = 0
    button.onClick {clicks++}
    return clicks
}*/

/* Yukarıda ki function her zaman 0 döndürür. onClick handler clicks value’sunu modify edecek olsa bile, modification’ı
observe edemezsin çünkü onClick handler function return ettikten sonra call edilecektir. Function’ın doğru bir
implementation’ı, click count’u local bir variable’da değil, function’ın dışından erişilebilir kalan bir location’da
store etmelidir — örneğin, bir class’ın property’sinde. Lambda’ları declare etme syntax’ını ve variable’ların
lambda’larda nasıl captured edildiğini ele aldık. Şimdi, mevcut function’lara referansları kolayca pass etmeni sağlayan
bir özellik olan member reference’lardan bahsedelim. */

fun main() {
    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessagesWithPrefix514(errors,"Error : ")
    // Error :  403 Forbidden
    // Error :  404 Not Found

    val responses = listOf("200 OK", "418 I'm a teapot", "500 Internal Server Error")
    printProblemCounts514(responses)
    // 1 client errors, 1 server errors
}