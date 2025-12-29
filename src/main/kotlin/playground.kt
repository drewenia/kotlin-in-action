fun main() {

}

internal open class TalkativeButton{
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}

// Hata: public bir member, internal receiver type TalkativeButton’ı expose ediyor (açığa çıkarıyor)
/*
fun TalkativeButton.giveSpeech(){
    yell() // Hata: yell’e erişilemez; TalkativeButton içinde private’tır
    whisper() // Hata: whisper’a erişilemez; TalkativeButton içinde protected’tır
}
*/
