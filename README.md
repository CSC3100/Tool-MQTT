![Static Badge](https://img.shields.io/badge/author-javiergs-orange)
![GitHub repo size](https://img.shields.io/github/repo-size/CSC3100/MQTT)
![GitHub Release](https://img.shields.io/github/v/release/CSC3100/MQTT)

# MQTT (Message Queuing Telemetry Transport) Example

...
<br>

## Publisher
This class is a simple MQTT publisher that sends messages to a TOPIC; the broker is test.mosquitto.org and the topic is cal-poly/csc/309.
Run this and the subscriber at the same time.
## Subscriber
This class is a simple MQTT subscriber that listens to a TOPIC; the BROKER is test.mosquitto.org and the topic is cal-poly/csc/309.
Run this and the publisher at the same time.

## Publish-Subscriber
This class is a simple MQTT publisher and subscriber (two in one). It publishes messages on two topics and listens to a one of it own topics; the test.mosquitto.org is used as broker. <b>This application can be run alone</b>.

## Blueprint
A drafted class diagram of the current release is as follows:

<p align="center">
<img width="600" src="https://github.com/CSC3100/MQTT/assets/3814755/b621ae2a-662c-4dae-993b-731617546fde">
</p>

> [!IMPORTANT]  
> **Allowing connections from clients outside of our machine**
> <p>When trying to send messages to the broker you might have noticed that when you connect to the broker from a different machine than the one where the broker was installed that you were unable to do so. </p>
> <p>This is due to the operating system not having the needed ports configured. To change this we have to create an inbound rule for mosquitto broker’s TCP port (by default it is port 1883 but you can change it in the .conf file). </p>
> <p>On Windows, open your Windows Defender Firewall (you can get to it by going to Control Panel > Change to large icons > Windows Defender Firewall)</p>
> <p>Go to Advanced settings</p>
> <p>Click on ‘Inbound Rules’ and then on ‘New Rule…’</p>
> <p>On the ‘New Inbound Rule Wizard” window, select ‘Port’ and hit next.</p>
> <p>Select ‘TCP’ and ‘Specific local port’, on the ports’ textbox type 1883 (or your mosquitto broker port if you changed it yourself in the .conf file). Hit next once you are done.</p>
> <p>Now select ‘Allow the connection’ and hit next.</p>
> <p>Now select to what domains that this rule applies to (Domain, private or public). You can select all but this is not recommended in a production environment. Hit next once you are done and finally type a name for your new rule. Name it something like ‘MQTT Broker Port’ and hit Finish.</p>
> <p>Now your rule is created and you should be able to connect from another machine in the same network.</p>
