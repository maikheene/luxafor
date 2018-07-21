package de.mwolf.luxaforapi.command;

import de.mwolf.luxaforapi.color.Color;
import de.mwolf.luxaforapi.device.luxafor.Led;
import de.mwolf.luxaforapi.type.Wave;

/**
 *
 * @author mwolf
 */
public class WaveCommand extends ColorCommand {
    
    private final Wave wave;
    private final Integer speed;
    private final Integer repead;

    public WaveCommand(Wave wave, Color color, Integer speed, Integer repead) {
        
        super(null, color);
        
        this.wave = wave;
        this.speed = speed;
        this.repead = repead;
    }
    
    @Override
    byte mode() {
        return 4;
    }

    @Override
    byte code() {
        return wave.getCode();
    }

    @Override
    byte byte6() {
        return repead.byteValue();
    }

    @Override
    byte byte7() {
       return speed.byteValue();
    }
    
}
