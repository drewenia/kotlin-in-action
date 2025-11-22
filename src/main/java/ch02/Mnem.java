package ch02;

enum Mnem {
    RED,
    GREEN,
    BLUE;

    public String getMnemonic() {
        return switch (this) {
            case RED -> "Richard";
            case GREEN -> "Gave";
            case BLUE -> "Battle";
        };
    }
}
