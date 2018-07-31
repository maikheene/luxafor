package de.mwolf.luxaforapi.device;

import de.mwolf.luxaforapi.exception.LuxaforException;

import javax.usb.*;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static java.text.MessageFormat.format;

public class Devices {


    public static <T extends Device> T findDevice(final Class<T> deviceClass) {
        DeviceSpec deviceSpec = readDeviceSpec(deviceClass);
        try {
            return findDevice(deviceClass, deviceSpec);
        } catch (UsbException e) {
            throw new LuxaforException(e);
        }
    }

    private static <T extends Device> T findDevice(final Class<T> deviceClass, final DeviceSpec deviceSpec)
            throws UsbException {

        UsbServices services = UsbHostManager.getUsbServices();

        UsbDevice usbDevice = readUsbDevice(services.getRootUsbHub(), deviceSpec);
        if (usbDevice == null) {
            throw new LuxaforException(
                    format("Can't find usb device for class {0}", deviceClass.getClass().getName())
            );
        }

        return createDevice(deviceClass, usbDevice);
    }

    private static <T extends Device> T createDevice(final Class<T> deviceClass, final UsbDevice usbDevice) {
        try {
            return deviceClass.getConstructor(UsbDevice.class).newInstance(usbDevice);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new LuxaforException(e);
        }
    }

    private static UsbDevice readUsbDevice(final UsbHub usbHub, final DeviceSpec deviceSpec) {
        for (UsbDevice device : readUsbDevices(usbHub)) {
            UsbDeviceDescriptor desc = device.getUsbDeviceDescriptor();
            if (isRequiredDevice(desc, deviceSpec)) {
                return device;
            }
            if (device.isUsbHub()) {
                device = readUsbDevice((UsbHub) device, deviceSpec);
                if (device != null) {
                    return device;
                }
            }
        }
        return null;
    }

    private static boolean isRequiredDevice(final UsbDeviceDescriptor desc, final DeviceSpec deviceSpec) {
        return desc.idVendor() == deviceSpec.getVendor() && desc.idProduct() == deviceSpec.getProduct();
    }

    private static List<UsbDevice> readUsbDevices(final UsbHub hub) {
        return (List<UsbDevice>) hub.getAttachedUsbDevices();
    }


    private static <T extends Device> DeviceSpec readDeviceSpec(final Class<T> deviceClass) {
        try {
            return deviceClass.getConstructor(UsbDevice.class).newInstance((UsbDevice) null);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new LuxaforException(e);
        }
    }

}
