package de.mwolf.luxaforapi.color;

public class Color {

    private final byte red;
    private final byte green;
    private final byte blue;

    public Color(byte red,  byte green, byte blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public byte getRed() {
        return red;
    }

    public byte getGreen() {
        return green;
    }

    public byte getBlue() {
        return blue;
    }
}
