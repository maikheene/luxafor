package de.mwolf.luxaforapi.command;

import de.mwolf.luxaforapi.color.Color;
import de.mwolf.luxaforapi.device.luxafor.Led;

public class FadeCommand extends ColorCommand {

    public static final Integer SPEED_SLOW = 100;
    public static final Integer SPEED_MIDDLE = 50;
    public static final Integer SPEED_FAST = 25;

    private static final int FADE_MODE = 2;
    private final Integer speed;

    public FadeCommand(Led led, Color color, Integer speed) {
        super(led, color);
        this.speed = speed;
    }

    @Override
    byte mode() {
        return FADE_MODE;
    }

    @Override
    byte byte5() {
        return speed.byteValue();
    }
}
