# Luxafor

A simple library to control your Luxafor device via [usb4java](http://usb4java.org/)

## About Luxafor

Luxafor is an LED indicator that connects to your computer through a USB port 
or via Bluetooth, and shows your availability or notifies you about important 
information, like incoming emails or calendar reminders.

Its Hardware Api is open, allowing developers to control the device through
their own applications.

You can go to http://luxafor.com/ to get more information about it.

## Usage 
```java
LuxaforDevice luxaforDevice = findDevice(LuxaforDevice.class);  
luxaforDevice.setColor(ALL, BLUE);
```

## API
### setColor(led, color)
Set led's color.