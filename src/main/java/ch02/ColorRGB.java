package ch02;

enum ColorRGB {
    RED(255, 0, 0),
    BLUE(0,0,255);

    private int r;
    private int g;
    private int b;

    ColorRGB(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    // With getter method for RGB
    public int getRGB(){
        return (r * 256 + g) * 256 + b;
    }
}
