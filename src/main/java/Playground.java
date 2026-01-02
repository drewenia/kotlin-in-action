import javax.swing.text.View;

public class Playground {
}

// Java Interface (Sadece bir tane abstract metod içeriyor -> SAM)
interface OnClickListener{
    void onClick(View v);
}

// Java Class (Bu interface'i parametre olarak alan bir metod içeriyor)
class Button {
    public void setOnClickListener(OnClickListener listener){
        // Tıklama olduğunda listener.onClick(this) çağrılır
    }
}