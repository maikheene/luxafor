# Luxafor

A simple java library to control your Luxafor device via [usb4java](http://usb4java.org/)

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
luxaforDevice.setColor(Led.ALL, Colors.BLUE);
```

### Maven

Just add following dependency definitions to your `pom.xml`.

```xml
<dependency>
  <groupId>com.github.maikwolf</groupId>
  <artifactId>Luxafor</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Known/Possible Issues

### Linux
- Sometimes first run doesn't work, have to run command a second time

#### Avoid Sudo Prompt
On Linux you need write permissions on the device file of the Luxafor USB device you want to communicate with. 
Check if the devices are accessible when running your program as root. If this works then it is recommended to 
configure `udev` to give your user write permissions when the device is attached.

1: Create a file, `/lib/udev/rules.d/50-luxafor.rules` with the following contents:

```
# Allow Luxafor USB control
ACTION=="add", SUBSYSTEMS=="usb", ATTRS{idVendor}=="04d8", ATTRS{idProduct}=="f372", MODE="660", GROUP="plugdev"
```

2: Reload the `udevadm` using the following commands:  
`sudo udevadm control --reload`  
`sudo udevadm trigger`

3: Unplug and reinsert your Luxafor device

### Windows
- Seems the Luxafor app has to be at least running in the tray for commands to persist
- Opening the Luxafor app switches the color to Green/Red (depeding on last used?)
- Seems that it doesn't always return to the exact same state it was in before a strobe or pattern is ran


## API
### setColor(led, color)
Simple method to change the color of the given led's.

```java
luxaforDevice.setColor(Led.ALL, Colors.BLUE);
//or
luxaforDevice.setColor(Led.ALL, Colors.hex2Rgb("#FFFFFF"));
```

### fadeColor(led, color, speed)
Similar to setColor, the only difference it will transition smoothly from previous color to the one specified.

Speed is a number 0-255 that represents the speed of the transition, 0 is the quickest 255 is the slowest.

```java
device.fadeColor(Led.ALL, Colors.BLUE, FadeCommand.SPEED_FAST);
//or 
device.fadeColor(Led.ALL, Colors.BLUE, 25);
```

### strobeColor(led, color, speed, repeat)

Strobe/Flash color for an amount of times specified in repeat parameter.

Speed 0 to 255 number determines delay between each blink

Repeat 0 to 255 number amount of times to blink before returning to previous state

```java
device.strobeColor(Led.ALL, Colors.GREEN, FadeCommand.SPEED_FAST, 10);
//or
device.strobeColor(Led.ALL, Colors.GREEN, 25, 10);
```

### wave(wave, color, speed, repeat)

Starts a wave that goes through all the leds with the pattern specified in type variable

There are 4 types available:
  * Wave.SHORT             - short wave
  * Wave.LONG              - long wave
  * Wave.SHORT_OVERLAPPING - overlapping short wave
  * Wave.LONG_OVERLAPPING  - overlapping long wave
  
```java
device.waveColor(Wave.LONG_OVERLAPPING, Colors.MAGENTA, FadeCommand.SPEED_FAST, 5);
//or
device.waveColor(Wave.LONG_OVERLAPPING, Colors.MAGENTA, 15, 5);
```

### off()
Turns off all leds