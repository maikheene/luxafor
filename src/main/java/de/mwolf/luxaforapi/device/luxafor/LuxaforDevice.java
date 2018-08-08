package de.mwolf.luxaforapi.device.luxafor;

import de.mwolf.luxaforapi.color.Color;
import de.mwolf.luxaforapi.command.ColorCommand;
import de.mwolf.luxaforapi.command.FadeCommand;
import de.mwolf.luxaforapi.command.OffCommand;
import de.mwolf.luxaforapi.command.PatternCommand;
import de.mwolf.luxaforapi.command.StrobeCommand;
import de.mwolf.luxaforapi.command.WaveCommand;
import de.mwolf.luxaforapi.device.Device;
import static de.mwolf.luxaforapi.device.luxafor.Led.ALL;
import de.mwolf.luxaforapi.exception.LuxaforException;
import de.mwolf.luxaforapi.type.Pattern;
import de.mwolf.luxaforapi.type.Wave;

import javax.usb.UsbDevice;

public class LuxaforDevice extends Device {

    public static final int LUXAFOR_USB_INTERFACE = 0;
    public static final int LUXAFOR_USB_ENDPOINT = 1;

    public LuxaforDevice(UsbDevice usbDevice) {
        super(usbDevice);
    }

    public void setColor(final Led led, final Color color) throws LuxaforException {
        sendCommand(new ColorCommand(led, color));
    }

    public void fadeColor(final Led led, final Color color, 
            final Integer speed) throws LuxaforException {
        
        sendCommand(new FadeCommand(led, color, speed));
    }
    
    public void strobeColor(final Led led, final Color color, 
            final Integer speed, final Integer repeat) throws LuxaforException {
        
        sendCommand(new StrobeCommand(led, color, speed, repeat));
    }
    
    public void waveColor(final Wave wave, final Color color, 
            final Integer speed, final Integer repeat) throws LuxaforException {
        
        sendCommand(new WaveCommand(wave, color, speed, repeat));
    }
    
    public void pattern(final Pattern pattern, final Integer repeat) throws LuxaforException {
        sendCommand(new PatternCommand(pattern, repeat));
    }
    
    public void setOff() throws LuxaforException {
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
