package ch03

/* Bir extension function define ettiğinde, otomatik olarak tüm project genelinde kullanılabilir hâle gelmez. Bunun
yerine, diğer class veya function’larda olduğu gibi import edilmesi gerekir. Bu, kazara oluşabilecek name
conflict’lerini önlemeye yardımcı olur. Kotlin, class’lar için kullandığın syntax’ın aynısını kullanarak tek tek
function’ları import etmene izin verir: */

/*
import strings.lastChar
val c = "Kotlin".lastChar()

Elbette, * import’ları da çalışır:
import strings.*
*/

/* Import ettiğin class ya da function’ın adını **as** keyword’ünü kullanarak değiştirebilirsin:

import strings.lastChar as last
val c = "Kotlin".last()

*/

/* Import sırasında bir name’i değiştirmek, farklı package’larda aynı ada sahip birden fazla function olduğunda ve
bunları aynı file içinde kullanmak istediğinde faydalıdır. Normal class veya function’lar için bu durumda başka bir
seçeneğin daha vardır: class ya da function’a fully qualified name kullanarak referans verebilirsin (ve bir class ya da
function’ı import edip edemeyeceğin, onun visibility modifier’ına da bağlıdır). Extension function’lar için ise syntax,
short name kullanmanı gerektirir; bu nedenle conflict’i çözmenin tek yolu, import statement içinde as keyword’ünü
kullanmaktır. */