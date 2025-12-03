package ch04;

public class JavaButton implements Clickable, Focusable{
    public static void main(String[] args) {
        JavaButton button = new JavaButton();
        button.showOff();
    }
    @Override
    public void click() {
        System.out.println("I was clicked");
    }

    @Override
    public void showOff() {
        System.out.println("I am showing off");
        // Kitap olmaz dediği halde aşağıda ki iki call da çalışıyor
        // Clickable.super.showOff();
        // Focusable.super.showOff();
    }
}
