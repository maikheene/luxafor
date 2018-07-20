package de.mwolf.luxaforapi;

import de.mwolf.luxaforapi.device.luxafor.LuxaforDevice;

import static de.mwolf.luxaforapi.color.Colors.*;
import static de.mwolf.luxaforapi.command.FadeCommand.SPEED_SLOW;
import static de.mwolf.luxaforapi.device.Devices.findDevice;
import static de.mwolf.luxaforapi.device.luxafor.Led.ALL;
import static java.lang.Thread.sleep;

/**
 *
 * @author mwolf
 */
public class Main {

    public static void main(String[] args) throws Exception {
        final LuxaforDevice luxaforDevice = findDevice(LuxaforDevice.class);
        luxaforDevice.setColor(ALL, BLUE);

        sleep(2000);

        luxaforDevice.fadeColor(ALL, RED, SPEED_SLOW);

        sleep(4000);

        luxaforDevice.setColor(ALL, GREEN);
    }

}
