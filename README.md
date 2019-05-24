# FindMe  

FindMe is a smart status indicator system created with Raspberry Pi and E-ink display. The project started in mid-August 2018 by Nitis Monburinon. The project is named by Prof. Zabir later and has become a regular project that we show to lab visitors presented during our demonstration session.

In Japan, usually, lecturers and researchers have customs to use something like whiteboard or paper to indicate their statuses in their workplaces. 

These indicators tell their visitors whether the lecturers are available or not. Are lecturers at lunch or having meetings? 

Are they home or working overtime? Visitors can tell by looking at indicators in front of the lecturers’ places.  

This system very useful in many situations and we thought we could improve its usefulness further by adding IOT and E-Ink technology to it. 

> Electronic ink technology produces a low-power paperlike display used primarily in early e-book readers such as Amazon's Kindle. Initial research on e-ink started at MIT's Media Lab, where the first patent was filed in 1996. 
The rights to the proprietary technology currently are owned by the Massachusetts-based E Ink Corporation, which was acquired by Taiwanese company Prime View International in 2009. E-ink technology in early e-readers works by using tiny microcapsules that are suspended in a liquid placed within a film layer. The microcapsules, which are about the same width as human hair, contain both positively charged white particles and negatively charged black particles. Applying a negative electrical field causes the white particles to come to the surface. Conversely, applying a positive electrical field causes the black particles to come to the surface. By applying different fields at various parts of a screen, e-ink produces a text display. E-ink displays are especially popular due to their resemblance to printed paper. Besides being considered by many as easier on the eyes than other display types, e-ink also boasts lower power consumption, particularly when compared to traditional backlit liquid crystal display (LCD) screens. 
Considering all the advantage E-ink displays provide, we adopt the technology in our FindMe project. FindMe can be deployed in front of any workplace or office. Users can use an Android mobile application to send messages to it from anywhere. 

As the display only refresh once it receives messages, power consumption is low. 

FindMe keeps texts on the display for a long time even when it’s not powered. This is useful when power is unavailable.

The E-ink display has its own low-level library written in C. But I have developed a high-level API that easily understandable using Python. 

At the current state, English, Japanese, and Thai were tested and proved to work correctly on the display.

## Prerequisite

Intermediate computer programming knowledge is mandatory. Others than that knowing the following subjects are highly recommended.
* Python for microcontroller programming.
* Java for Android application development.
* Prior experience working with a microcontroller such as Arduino and Raspberry Pi. As well as common sensor modules.
* Fundamental knowledge of electronic engineering. 
* Internet of Things concept in general.

The following electronic components are essential. You can find most of them scattered around the lab. If any of them is missing, you need to ask our supervisor to buy a new one or come up with alternative yourself.
* A working, not broken, Raspberry Pi. Also, its power supply adapter.
* A micro sd card for installing OS.
* An E-Ink display. 

## Setup

### Raspberry Pi

Firstly, get everything from the previous section from the lab. If any of them aren’t working, contact our supervisor ASAP. 

1. Absolutely don’t power Pi during this step, for your own and device safety. Attach E-ink display directly on the Pi, as shown in the figure.

2. Open the terminal, run this command to open raspberry pi configuration menu.

      sudo raspi-config
   
   Here you need to enable SPI by selecting **Inferfacing Options** => **P4 SPI** then hit **Yes** to confirm.

3. Go to $HOME directory, clone the E-ink display API repository using a command.

      cd ~
		git clone https://github.com/boonitis/findme-client.git

4. Get into the cloned directory. Run install_requirement.sh to install dependencies.

      cd findme-client
      bash install_requirement.sh

5. Using sudo privilage, copy  findme.service to the systemd service directoriy.

      sudo cp findme.service /etc/systemd/system/

6. Copy findme-helper.sh to the $HOME directory.
   
      cp findme-helper.sh ~

7. Run the following command to setup autostart service that will run app.py as a daemon when this Pi is booted.
   
      sudo systemctl daemon-reload
      sudo systemctl start findme
      sudo systemctl enable findme

8. Confirm whether the daemon (service) is working by rebooting the device and run this command.

      sudo systemctl status findme
    
### Android Application

1.	On your PC, download Android Studio and Android Debug Bridge (adb)
	clone this repository using a command

		git clone https://github.com/boonitis/find-me.git
        
	And then open your Android Studio **File** -> **New** -> **Import Project** then choose the cloned project folder.

1. Connect your smartphone to your PC using a USB cable.

2. In Android Studio, click the app module in the Project window then select Run -> Run and select [Your device name] as your deployment target.

3. After the installation process, look for the FindMe app on your smartphone. Try sending a message to the Raspberry Pi.

## Demonstration Guide

You can let the users type a message and send to the display. When you explain how E-ink display consumes very little power consumption, try unplugging Raspberry Pi and show that E-ink display retains all the text even without electricity. I tried it, and I think it was quite impressive. 

I guess that all it is for FindMe. 
