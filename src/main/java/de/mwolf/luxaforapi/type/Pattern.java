package de.mwolf.luxaforapi.type;

/**
 *
 * @author mwolf
 */
public enum Pattern {
    
    BLINK_WHITE(1),
    
    RANDOM_1(2),
    
    RANDOM_2(3),
    
    RANDOM_3(4),
    
    RANDOM_4(6),
    
    RANDOM_5(7),
    
    POLICE(5),
    
    RAINBOW_WAVE(8);
    
    private final Integer code;

    private Pattern(Integer code) {
        this.code = code;
    }

    public byte getCode() {
        return code.byteValue();
    }
    
    
}
