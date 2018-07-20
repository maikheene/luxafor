package de.mwolf.luxaforapi.device;

import de.mwolf.luxaforapi.command.Command;
import de.mwolf.luxaforapi.exception.LuxaforException;

import javax.usb.*;

public abstract class Device implements DeviceSpec {

    private final UsbDevice usbDevice;

    public abstract byte getUsbInterfaceNumber();

    public abstract byte getUsbEndpointNumber();

    public abstract boolean detachDeviceDriver();

    public Device(UsbDevice usbDevice) {
        this.usbDevice = usbDevice;
    }

    public void sendCommand(final Command command) {
        try {
            sendCommand(command.getCommandMessage());
        } catch (UsbException e) {
            throw new LuxaforException();
        }
    }

    private void sendCommand(final byte[] message) throws UsbException {
        UsbInterface iface = getIFace();
        try {
            if (detachDeviceDriver()) {
                detachDeviceDriver(iface);
            }

            sendMessageOverUsbPipe(iface, message);
        } finally {
            iface.release();
        }
    }

    private void sendMessageOverUsbPipe(final UsbInterface iface, final byte[] message) throws UsbException {
        final UsbPipe pipe = getUsbPipe(iface);

        pipe.open();
        try {
            pipe.syncSubmit(message);
        } finally {
            pipe.close();
        }
    }

    private UsbPipe getUsbPipe(final UsbInterface iface) {
        UsbEndpoint endpoint = iface.getUsbEndpoint(getUsbEndpointNumber());

        if (endpoint == null) {
            throw new LuxaforException();
        }

        UsbPipe result = endpoint.getUsbPipe();
        if (result == null) {
            throw new LuxaforException();
        }

        return result;
    }

    private UsbInterface detachDeviceDriver(final UsbInterface iface) throws UsbException {
        iface.claim(usbInterface -> true);
        return iface;
    }

    private UsbInterface getIFace() {
        final UsbConfiguration configuration = usbDevice.getActiveUsbConfiguration();

        if (configuration == null) {
            throw new LuxaforException();
        }

        final UsbInterface result = configuration.getUsbInterface(getUsbInterfaceNumber());

        if (result == null) {
            throw  new LuxaforException();
        }

        return result;
    }
}
