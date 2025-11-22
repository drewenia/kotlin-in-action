package ch02;

public enum ColorRGB_v2 {
    RED(255, 0, 0),
    BLUE(0, 0, 255);

    private int r;
    private int g;
    private int b;
    private int rgb;

    // With Constructor for RGB
    ColorRGB_v2(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.rgb = (r * 256 + g) * 256 + b;
    }

    public int getRgb(){
        return this.rgb;
    }
}
