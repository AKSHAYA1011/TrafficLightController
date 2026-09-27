# Traffic Light Controller

A simple **Traffic Light Controller desktop application** developed using **Java Swing**. The application simulates a traffic signal system with Red, Yellow, and Green lights and provides Start and Stop controls.

## Features

* 🔴 Red light for 5 seconds
* 🟡 Yellow light for 2 seconds
* 🟢 Green light for 5 seconds
* Automatic switching between traffic lights
* Start button to begin the traffic signal
* Stop button to stop the signal
* Simple and user-friendly graphical interface

## Technologies Used

* **Java**
* **Java Swing**
* **AWT**
* **Eclipse IDE**

## Project Structure

```text
TrafficLightProject
│
└── src
    └── light
        └── TrafficLightController.java
```

## How It Works

The application uses the Java Swing `Timer` to control the duration of each traffic light.

The sequence is:

```text
Red → Yellow → Green → Red
```

Each light has a predefined time:

| Traffic Light |  Duration |
| ------------- | --------: |
| Red           | 5 seconds |
| Yellow        | 2 seconds |
| Green         | 5 seconds |

When the **Start** button is pressed, the traffic light sequence begins. The **Stop** button stops the timer.

## How to Run

### Using Eclipse

1. Open the project in Eclipse.
2. Make sure a Java JDK is configured.
3. Navigate to:
   `src → light → TrafficLightController.java`
4. Right-click the Java file.
5. Select **Run As → Java Application**.
6. Click **Start** to begin the traffic signal.

## Requirements

* Java JDK 8 or above
* Eclipse IDE or any Java-supported IDE

No external libraries or dependencies are required because Swing and AWT are included in the Java JDK.

## Future Enhancements

* Add pedestrian crossing functionality
* Add countdown timers
* Add sound alerts
* Add emergency vehicle priority
* Add customizable light timings




B.E. Electronics and Communication Engineering
