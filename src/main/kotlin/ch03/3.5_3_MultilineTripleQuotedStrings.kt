package ch03

/* Üçlü tırnaklı string’lerin amacı yalnızca karakterleri escape etmekten kaçınmak değildir. Bu tür bir string
literal’ı, satır sonları da dahil olmak üzere herhangi karakterleri içerebilir. Bu da, satır sonları içeren metinleri
programlarının içine kolayca gömmeni sağlar. Örnek olarak, biraz ASCII art çizelim: */

val kotlinLogo =
    """
    ========
       ||
       ||
       ||
    """.trimIndent()

fun main() {
    println(kotlinLogo)
}

/* Multiline string, üçlü tırnaklar arasındaki tüm karakterleri içerir. Buna, code’u biçimlendirmek için kullanılan
satır sonları ve indent’ler de dahildir. Bu gibi durumlarda, büyük olasılıkla yalnızca string’in gerçek content’iyle
ilgilenirsin. trimIndent call ederek, string’deki tüm satırların ortak olan en küçük indent’ini kaldırabilir ve boş
olmaları koşuluyla string’in ilk ve son satırlarını da silebilirsin. Önceki örnekte gördüğün gibi, üçlü tırnaklı bir
string satır sonları içerebilir; ancak \n gibi özel karakterleri kullanamazsın. Öte yandan, \ karakterini escape etmen
gerekmez; bu nedenle Windows tarzı path olan "C:\Users\yole\kotlin-book", """C:\Users\yole\kotlin-book""" şeklinde
yazılabilir. Multiline string’lerde string template’leri de kullanabilirsin. Multiline string’ler escape sequence’leri
desteklemediği için, string içeriğinde literal bir dollar sign ya da escape edilmiş bir Unicode symbol kullanman
gerekiyorsa embedded expression kullanmak zorundasın. Bu nedenle val think = """Hmm \uD83E\uDD14""" yazmak yerine,
string içinde encode edilmiş escape edilmiş symbol’ün doğru şekilde yorumlanması için şunu yazman gerekir:
val think = """Hmm ${"\uD83E\uDD14"}""". Multiline string’lerin programlarında faydalı olabileceği alanlardan biri
(ASCII art kullanan oyunların yanı sıra) test’lerdir. Test’lerde, multiline text üreten bir operation’ı (örneğin bir
web page fragment’ı ya da başka bir structured text) çalıştırmak ve sonucu expected output ile compare etmek oldukça
yaygındır. Multiline string’ler, expected output’u test’lerinin bir parçası olarak dahil etmek için mükemmel bir çözüm
sunar. Hantal escaping’e ya da text’i external file’lardan yüklemeye gerek yoktur—sadece birkaç quotation mark ekle ve
expected HTML, XML, JSON ya da başka bir output’u aralarına yerleştir. Daha iyi formatting için ise, daha önce
bahsedilen trimIndent function’ını kullan; bu da bir başka extension function örneğidir. */

val expectedPage353 = """
    <html lang="en">
        <head>
            <title>A page</title>
        </head>
        <body>
            <p>Hello, Kotlin!</p>
        </body>
    </html>
""".trimIndent()
val expectedObject353 = """
    {
        "name": "Sebastian",
        "age": 27,
        "homeTown": "Munich"
    }
    """.trimIndent()

/* Artık extension function’ların, mevcut library’lerin API’lerini genişletmek ve onları Kotlin dilinin idiom’larına
uyarlamak için güçlü bir yol olduğunu görebilirsin. Nitekim Kotlin standard library’nin büyük bir bölümü, standart Java
class’ları için yazılmış extension function’lardan oluşur. */