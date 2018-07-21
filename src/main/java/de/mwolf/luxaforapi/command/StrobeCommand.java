package de.mwolf.luxaforapi.command;

import de.mwolf.luxaforapi.color.Color;
import de.mwolf.luxaforapi.device.luxafor.Led;

/**
 *
 * @author mwolf
 */
public class StrobeCommand extends ColorCommand{

    private final Integer speed;
    private final Integer repeat;
    
    public StrobeCommand(final Led led, final Color color, final Integer speed, 
            final Integer repeat) {
        
        super(led, color);
        this.speed = speed;
        this.repeat = repeat;
    }

    @Override
    byte mode() {
        return 3; 
    }
    
    @Override
    byte byte5() {
        return speed.byteValue();
    }
    
    @Override
    byte byte7() {
        return repeat.byteValue();
    }


    
    
}
