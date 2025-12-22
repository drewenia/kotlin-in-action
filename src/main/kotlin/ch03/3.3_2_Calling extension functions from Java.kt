package ch03

/* İç tarafta, bir extension function, receiver object’i ilk argument olarak alan bir static method’dur. Onu çağırmak
adapter object’ler ya da başka herhangi bir run-time overhead oluşturmayı içermez. Bu da extension function’ları
Java’dan kullanmayı oldukça kolay hale getirir: static method’u çağırır ve receiver object instance’ını geçirirsin.
Diğer top-level function’larda olduğu gibi, method’u içeren Java class’ının adı, function’ın declared edildiği file’ın
adından belirlenir. Diyelim ki StringUtil.kt adlı bir file’da declared edilmiş olsun:

/* Java */
char c = StringUtilKt.lastChar("Java");
*/

/* Bu extension function top-level function olarak declared edilmiştir, bu yüzden static method olarak compile edilir.
Java’dan lastChar method’unu static olarak import edebilirsin; bu da kullanımı yalnızca lastChar("Java") şeklinde
basitleştirir. Bu code, Kotlin version’a kıyasla biraz daha az okunabilirdir, ancak Java bakış açısından idiomatic’tir.
*/