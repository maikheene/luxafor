package de.mwolf.luxaforapi.type;

/**
 *
 * @author mwolf
 */
public enum Wave {
    SHORT(1),
    
    LONG(2),
    
    SHORT_OVERLAPPING(3),
    
    LONG_OVERLAPPING(4);
    
    private final Integer code;

    private Wave(Integer code) {
        this.code = code;
    }

    public byte getCode() {
        return code.byteValue();
    }
}
