package ch01

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class WritingSpringBoot

/* Bu örnekte, HTTP üzerinden JSON olarak bir ID ve biraz text’ten oluşan bir Greeting object listesi servis eden
basit bir Spring Boot application’ı define ediyorsun. Spring framework’ündeki concept’ler doğrudan Kotlin’e aktarılır:
Java kullanırken olduğu gibi aynı annotation’ları (@SpringBootApplication, @RestController, @GetMapping) kullanırsın.
*/

/* *args ifadesi Kotlin’de spread operator olarak adlandırılır. **args** bir Array<String>’dir.
runApplication<WritingSpringBoot>(*args) yazdığında, bu array’i tek tek elemanlarına açarak fonksiyona gönderirsin.
Yani:

*args → arg1, arg2, arg3, ... şeklinde fonksiyona yayılır.

Eğer * kullanmazsan, tüm array tek bir parametre olarak iletilmiş olur ve bu da runApplication için doğru olmaz.
runApplication Spring Boot tarafından sağlanan bir başlatma (bootstrap) fonksiyonudur. Belirttiğin Kotlin/Spring Boot
application’ını başlatır. Spring konteynerini oluşturur. Bean’leri yükler. Web server (Tomcat, Jetty vs.) gerekiyorsa
ayağa kaldırır. Application başlatma süreçlerinin tümünü yönetir.
*/
fun main(args: Array<String>) {
    runApplication<WritingSpringBoot>(*args)
}

@RestController
class GreetingController{
    @GetMapping
    fun index() : List<GreetingDeriver> = listOf(
        GreetingDeriver(1,"Hello"),
        GreetingDeriver(2,"Bonjour"),
        GreetingDeriver(2,"Guten Tag")
    )
}

data class GreetingDeriver(val id : Int, val greeting : String)
