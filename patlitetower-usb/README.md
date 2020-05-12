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

`java -jar patlitetower-usb-full-0.0.1-SNAPSHOT.jar`

```
 -v (--version)                                                                 : prints version of this software
 -d (--dll-version)                                                             : prints version of the underlying patlite tower dll
 -f (--firmware-version)                                                        : prints firmware version of the connected patlite tower
 -r (--reset)                                                                   : reset patlite tower
 -s (--light, --set-light, --single) [OFF | ON | NORMAL | SLOW | DOUBLE | FAST  : set a single light
 | KEEP_EXISTING]
 -c (--color) [RED | AMBER | GREEN | BLUE | CLEAR]                              : specify color to set
 -a (--all) RED AMBER GREEN BLUE CLEAR (each of [OFF | ON | NORMAL | SLOW |     : set all lights at once.
 DOUBLE | FAST | KEEP_EXISTING])
 -b (--buzzer) [OFF | ON | NORMAL | SLOW | DOUBLE | FAST | KEEP_EXISTING]       : specify state for buzzer to set
 -l (--limit)                                                                   : limit sound of buzzer
 -p1 (--pitch1) [OFF | DEFAULT | PITCH1 | PITCH2 | PITCH3 | PITCH4 | PITCH5 |   : set pitch 1 of buzzer
 PITCH6 | PITCH7 | PITCH8 | PITCH9 | PITCH10 | PITCH11 | PITCH12 | PITCH13]
 -p2 (--pitch2) [OFF | DEFAULT | PITCH1 | PITCH2 | PITCH3 | PITCH4 | PITCH5 |   : set pitch 2 of buzzer
 PITCH6 | PITCH7 | PITCH8 | PITCH9 | PITCH10 | PITCH11 | PITCH12 | PITCH13]
```

### full (patlitetower-usb-full)

A sub project to create a distribution of the whole library, without any external dependencies.
It actually removes all JNA related stuff which is not used on Windows, the whole library then comes
in at around 590kB.
