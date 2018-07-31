package de.mwolf.luxaforapi;

import de.mwolf.luxaforapi.color.Colors;
import de.mwolf.luxaforapi.device.Devices;
import de.mwolf.luxaforapi.device.luxafor.Led;
import de.mwolf.luxaforapi.device.luxafor.LuxaforDevice;
import de.mwolf.luxaforapi.type.Wave;

public class Main {

    public static void main(String[] args) throws Exception {
        final LuxaforDevice device = Devices.findDevice(LuxaforDevice.class);

        device.setColor(Led.ALL, Colors.RED);

        Thread.sleep(1000);

        device.fadeColor(Led.ALL, Colors.BLUE, 75);

        Thread.sleep(3000);

        device.strobeColor(Led.ALL, Colors.GREEN, 15, 5);

        Thread.sleep(5000);

        device.waveColor(Wave.LONG_OVERLAPPING, Colors.MAGENTA, 15, 5);

        Thread.sleep(5000);

        device.setOff();
    }

}
