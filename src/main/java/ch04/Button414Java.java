package ch04;

public class Button414Java implements View414{
    @Override
    public State414 getCurrentState() {
        return new ButtonState();
    }

    @Override
    public void restoreState(State414 state) {}

    public class ButtonState implements State414{}
}
