package de.mwolf.luxaforapi.command;

import de.mwolf.luxaforapi.color.Color;
import de.mwolf.luxaforapi.device.luxafor.Led;

public class ColorCommand extends Command {

    private static final int COLOR_MODE = 1;

    private final Led led;
    private final Color color;

    public ColorCommand(Led led, Color color) {
        this.led = led;
        this.color = color;
    }

    @Override
    byte mode() {
        return COLOR_MODE;
    }

    @Override
    byte code() {
        return led.getCode();
    }

    @Override
    byte byte2() {
        return color.getRed();
    }

    @Override
    byte byte3() {
        return color.getGreen();
    }

    @Override
    byte byte4() {
        return color.getBlue();
    }

    @Override
    byte byte5() {
        return 0;
    }

    @Override
    byte byte6() {
        return 0;
    }

    @Override
    byte byte7() {
        return 0;
    }
}
