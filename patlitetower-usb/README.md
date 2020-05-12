# PATLITETower-USB Java library

A JNA based library to access the PATLITE LR6 USB Signal Tower.

For now there will be no official release of the library, since the licensing terms
of the DLL prohibit redistribution. So you'll have to build it yourself.

## How To Build

Just navigate into patlitetower-usb and run:

`mvn package` 

## The sub-projects

### patlitetower-usb (patlitetower-usb-parent)

The Maven parent project. The whole project must be build with Java 8+. The library itself should 
work fine with Java 6 and later. It is only tested with Java 6, Java 8 and Java 11.

### lib (patlitetower-usb-lib)

The raw interface to the PATLITE DLL. When building it will download the necessary
DLLs automatically. The only dependency is JNA.

### api (patlitetower-usb-api)

A somewhat niceer to use Java interface.

### cli (patlitetower-usb-cli)

A command line client, based on args4j.

### full (patlitetower-usb-full)

A sub project to create a distribution of the whole library, without any external dependencies.
It actually removes all JNA related stuff which is not used on Windows, the whole library then comes
in at around 590kB.
