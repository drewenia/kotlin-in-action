package ch06

/* Functional programming style, collection’ları manipüle ederken birçok avantaj sağlar. Çoğu görev için, standart
library tarafından sağlanan function’ları kullanabilir ve bu function’lara lambda’ları argument olarak pass ederek
davranışlarını customize edebilirsin. Collection’larda manuel olarak gezinip veri toplamakla karşılaştırıldığında, bu
yaklaşım ortak operasyonları tutarlı bir şekilde ifade etmene olanak tanır ve diğer Kotlin developer’larıyla paylaştığın
bir function vocabulary kullanmanı sağlar. Bu bölümde, collection’larla çalışırken sıklıkla kullanabileceğin bazı Kotlin
standart library function’larını inceleyeceğiz. Collection’ları dönüştürmene yardımcı olan filter ve map gibi temel
function’larla ve bu function’ların arkasındaki kavramlarla başlayacağız. Ayrıca diğer faydalı function’ları ele alacak
ve bunları aşırı kullanmaktan nasıl kaçınacağını ve kodu nasıl clear ve anlaşılır yazacağını göstereceğiz. Unutma ki,
bu function’lar Kotlin tasarımcıları tarafından icat edilmemiştir. Bu ve benzer function’lar, lambda destekleyen tüm
dillerde mevcuttur; örneğin C#, Groovy ve Scala. Eğer bu kavramlara zaten aşinaysan, aşağıdaki example’lara hızlıca göz
atabilir ve açıklamaları atlayabilirsin. */