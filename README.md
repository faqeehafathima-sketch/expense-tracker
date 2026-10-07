# SUBSENSE-X

An Android prototype for monitoring underground mine subsidence using a local sensor-field simulation.

## What it does

The current Android app demonstrates the software side of a mine-safety monitoring system:

- Simulates a 5 × 5 field of surface sensor nodes
- Generates deformation, velocity, crack, vibration, battery and RSSI readings
- Calculates a transparent 0–100 ground-risk score
- Looks for spatially coherent movement
- Detects a simulated sensor fault and excludes it from ground-risk scoring
- Shows a live sensor map, risk trend, telemetry, alerts and decision trace
- Runs the core demo without an Internet connection
- Uses Android local notifications for high-risk events

## Current status

**Software prototype / simulator.**

The present version does **not** read real LoRa, Zigbee or physical sensor hardware. Telemetry is generated locally so the monitoring and alert workflow can be demonstrated before hardware integration.

The risk score is a rule-based weighted score, not a trained machine-learning model. The displayed confidence value is an internal heuristic and should not be interpreted as statistical probability.

## Android stack

- Kotlin
- Jetpack Compose
- Material 3
- Android SDK 35
- Gradle
- AndroidX Activity / Core

## Project structure

```text
SubsenseXAdvanced/
└── app/
    ├── src/main/
    │   ├── java/com/subsensex/advanced/MainActivity.kt
    │   ├── AndroidManifest.xml
    │   └── res/
    └── build.gradle.kts

expense_tracker.py
requirements.txt
```

The Python expense tracker is an earlier standalone learning project kept in the same repository. It is not part of the Android mine-monitoring app.

## Run the Android prototype

Open the `SubsenseXAdvanced` directory in Android Studio, let Gradle sync, then run the `app` configuration on an Android device or emulator.

The app starts with a local simulated telemetry stream. Use the scenario controls to demonstrate:

- normal sensor behaviour
- local deformation
- progressive subsidence
- sensor failure

## Important limitations

This prototype is intended for software demonstration and development. It is **not a certified mine-safety system** and should not be used for real operational safety decisions.

Hardware integration, persistent telemetry storage, store-and-forward synchronization, field calibration and validation with real sensor data are future development work.

## Author

**Faqeeha Fathima**  
B.Tech Artificial Intelligence & Data Science
