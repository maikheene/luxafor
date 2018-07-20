package de.mwolf.luxaforapi.device.luxafor;

public enum Led {

    ALL((byte) 0xFF),

    FRONT((byte) 0x41),

    BACK((byte) 0x42);

    private final byte code;

    Led(byte code) {
        this.code = code;
    }

    public byte getCode() {
        return code;
    }
}
