package ch05

/* Bu bölüm, Kotlin standart library’sindeki with, apply ve also function’larını gösterir. Bu function’lar kullanışlıdır
ve nasıl declare edildiklerini anlamasan bile onlar için birçok kullanım alanı bulacaksın. Bu bölümdeki açıklamalar,
Kotlin lambda’larının Java’da bulunmayan özgün bir özelliğine aşina olmanı sağlar: bir lambda’nın body’si içinde,
herhangi bir ek qualifier olmadan farklı bir object’in method’larını call edebilme yeteneği. Bu tür lambda’lara
receiver’lı lambda’lar denir. Receiver’lı bir lambda kullanan with function’a bakarak başlayalım. */