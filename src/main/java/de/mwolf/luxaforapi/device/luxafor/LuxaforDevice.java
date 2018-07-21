package de.mwolf.luxaforapi.device.luxafor;

import de.mwolf.luxaforapi.color.Color;
import de.mwolf.luxaforapi.command.ColorCommand;
import de.mwolf.luxaforapi.command.FadeCommand;
import de.mwolf.luxaforapi.command.OffCommand;
import de.mwolf.luxaforapi.device.Device;
import static de.mwolf.luxaforapi.device.luxafor.Led.ALL;

import javax.usb.UsbDevice;

public class LuxaforDevice extends Device {

    public static final int LUXAFOR_USB_INTERFACE = 0;
    public static final int LUXAFOR_USB_ENDPOINT = 1;

    public LuxaforDevice(UsbDevice usbDevice) {
        super(usbDevice);
    }

    public void setColor(final Led led, final Color color) {
        sendCommand(new ColorCommand(led, color));
    }

    public void fadeColor(final Led led, final Color color, final Integer speed) {
        sendCommand(new FadeCommand(led, color, speed));
    }
    
    public void setOff() {
        sendCommand(new OffCommand());
    }

    @Override
    public byte getUsbInterfaceNumber() {
        return LUXAFOR_USB_INTERFACE;
    }

    @Override
    public byte getUsbEndpointNumber() {
        return LUXAFOR_USB_ENDPOINT;
    }

    @Override
    public boolean detachDeviceDriver() {
        return true;
    }

    @Override
    public short getVendor() {
        return (short) 0x04d8;
    }

    @Override
    public short getProduct() {
        return (short) 0xf372;
    }
}
