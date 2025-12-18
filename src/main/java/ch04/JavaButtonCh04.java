package ch04;

public class JavaButtonCh04 implements Clickable411v2{
    @Override
    public void click() {
        System.out.println("I was clicked");
    }

    @Override
    public void showOff() {
        System.out.println("I am showing off");
    }
}
