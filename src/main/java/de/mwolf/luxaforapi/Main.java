package de.mwolf.luxaforapi;

import java.util.List;
import javax.usb.UsbConfiguration;
import javax.usb.UsbConst;
import javax.usb.UsbControlIrp;
import javax.usb.UsbDevice;
import javax.usb.UsbDeviceDescriptor;
import javax.usb.UsbEndpoint;
import javax.usb.UsbHostManager;
import javax.usb.UsbHub;
import javax.usb.UsbInterface;
import javax.usb.UsbInterfacePolicy;
import javax.usb.UsbPipe;
import javax.usb.UsbServices;

/**
 *
 * @author mwolf
 */
public class Main {

    public static void main(String[] args) throws Exception {
        UsbServices services = UsbHostManager.getUsbServices();
        short vendor = (short) 0x04d8;
        short product = (short) 0xf372;
        UsbDevice usbDevice = findDevice(services.getRootUsbHub(), vendor, product);
        sendMessage(usbDevice);
    }

    public static void sendMessage(UsbDevice device) throws Exception {
        UsbConfiguration configuration = device.getActiveUsbConfiguration();
        UsbInterface iface = configuration.getUsbInterface((byte) 0);
        try {
            iface.claim(new UsbInterfacePolicy() {
                @Override
                public boolean forceClaim(UsbInterface usbInterface) {
                    return true;
                }
            });
            UsbEndpoint endpoint = iface.getUsbEndpoint((byte) 1);
            UsbPipe pipe = endpoint.getUsbPipe();

            byte[] message = {
                1,
                (byte) 0x41,
                (byte) 0,
                (byte) 255,
                0
              
            };

            pipe.open();
            try {
                int sent = pipe.syncSubmit(message);
                System.out.println(sent + " bytes sent");
            } finally {
                pipe.close();
            }
        } finally {
            iface.release();
        }
    }

    public static UsbDevice findDevice(UsbHub hub, short vendorId, short productId) {
        for (UsbDevice device : (List<UsbDevice>) hub.getAttachedUsbDevices()) {
            UsbDeviceDescriptor desc = device.getUsbDeviceDescriptor();
            if (desc.idVendor() == vendorId && desc.idProduct() == productId) {
                return device;
            }
            if (device.isUsbHub()) {
                device = findDevice((UsbHub) device, vendorId, productId);
                if (device != null) {
                    return device;
                }
            }
        }
        return null;
    }
}
