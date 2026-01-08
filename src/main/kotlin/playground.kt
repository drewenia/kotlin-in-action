fun main() {
    val data = listOf(
        "Kotlin",
        "Java",
        "Scala"
    )

    val selectableTextList = SelectableTextList(data)
    val copyRowAction = CopyRowAction(selectableTextList)

    with(copyRowAction) {
        if (isActionEnabled()) executeCopyRow()
        else println("Buton pasif : seçili satır yok")
        // Buton pasif : seçili satır yok
    }

    selectableTextList.selectedIndex = 1
    with(copyRowAction){
        if (isActionEnabled()){
            println("Buton aktif islem gerceklestiriliyor")
            executeCopyRow()
            println("Basariyla kopyalandi ${selectableTextList.contents[selectableTextList.selectedIndex!!]}")
            // Buton aktif islem gerceklestiriliyor
            // Basariyla kopyalandi Java
        }
    }
}

class SelectableTextList(
    val contents: List<String>,
    var selectedIndex: Int? = null
)

class CopyRowAction(val list: SelectableTextList) {
    fun isActionEnabled(): Boolean = list.selectedIndex != null

    // executeCopyRow, yalnızca isActionEnabled true döndürdüğünde call edilir.
    fun executeCopyRow() {
        val index = list.selectedIndex!!
        val value = list.contents[index]
        // copy value to clipboard
    }
}

// data class Person(val name: String, val age: Int)

