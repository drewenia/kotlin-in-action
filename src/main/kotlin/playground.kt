import javax.swing.Action

class Button(val text: String, val onClick: () -> Unit)

fun logOut() {
    println("Oturum kapatıldı, ana sayfaya yönlendiriliyor...")
}

fun main() {
    val saveButton = Button("Save"){
        println("Save to database")
        println("Saved")
    }

    saveButton.onClick()
    // Save to database
    // Saved

    val logOutButton = Button("Logout",::logOut)
    logOutButton.onClick() // Oturum kapatıldı, ana sayfaya yönlendiriliyor...
}