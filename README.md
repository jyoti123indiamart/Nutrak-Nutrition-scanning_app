The Food Scanner App is a mobile application designed to help users track their food intake by scanning food items and providing nutritional information. The app also includes a streaks feature to motivate users to maintain consistent healthy eating habits.

**Setup Instructions**

**Prerequisites**

Android Studio (latest version recommended)
Android SDK (API level 21 or higher)
Kotlin (latest version recommended)

**Installation**

Clone the repository: git clone [https://github.com/jyoti123indiamart/Nutrak-Nutrition-scanning_app.git}

Launch the project in Android Studio.

Build the project: Click on Build > Make Project to build the project.

Ensure all dependencies are downloaded and synced.

Run the app on an Android device or start an emulator

**Libraries Used**

**1. Jetpack Compose**
   
Reason: Jetpack Compose is a modern toolkit for building native Android UI. It simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.
Usage: Used for building the entire UI of the app, including screens like ScanScreen, ResultsScreen, and StreaksScreen.

**2. Navigation Compose**
   
Reason: Navigation Compose is part of the Jetpack Compose library and provides a way to navigate between different composables in a Compose-based app.
Usage: Used to handle navigation between the ScanScreen, ResultsScreen, and StreaksScreen.

**3. Lottie**
   
Reason: Lottie is a library that renders After Effects animations in real-time, allowing for smooth and scalable animations.
Usage: Used for the streak badge animation in the StreaksScreen.

**4. MPAndroidChart**
   
Reason: MPAndroidChart is a powerful charting library for Android that supports various chart types, including pie charts, bar charts, and line charts.
Usage: Used to display the nutritional breakdown in a pie chart format on the ResultsScreen.

**5. Coil**
    
Reason: Coil is an image loading library for Android backed by Kotlin Coroutines. It is fast, lightweight, and easy to use.
Usage: Used to load and display images from the gallery in the ScanScreen.

**Relevant Notes and Assumptions**

Streak Calculation: The streak calculation is currently hardcoded for demonstration purposes. In a real-world scenario, this would be dynamically calculated based on user activity.

Nutritional Data: The nutritional data displayed in the ResultsScreen is static and for demonstration purposes only. In a real-world application, this data would be fetched from a backend service or a database.

Image Scanning: The app currently simulates the scanning process with a progress indicator. Actual image recognition and nutritional analysis would require integration with a machine learning model or API.

**Approach and Challenges**

**Approach**

**UI Design:**

The app's UI was designed using Jetpack Compose, which allowed for a declarative and reactive approach to building the user interface. This made it easier to create complex layouts and animations with less code.

The StreaksScreen was designed to be visually appealing with animations and a calendar view to track user streaks.

**Navigation:**

Navigation between screens was handled using Navigation Compose, which provided a seamless way to move between the ScanScreen, ResultsScreen, and StreaksScreen.

**Data Visualization:**

The ResultsScreen uses MPAndroidChart to display nutritional information in a pie chart format. This was chosen for its ease of use and ability to display data in a visually appealing way.

**Image Handling:**

Coil was used to handle image loading from the gallery. This library was chosen for its simplicity and performance benefits.

**Challenges**

**Streak Calculation:**

Implementing a dynamic streak calculation based on user activity was a challenge. For the purpose of this project, the streak data is hardcoded, but in a real-world application, this would need to be dynamically calculated and stored.

**Nutritional Data Integration:**

Integrating real-time nutritional data from an API or database was beyond the scope of this project. The current implementation uses static data, but future work would involve integrating with a backend service.

**Image Recognition:**

The app currently simulates the scanning process. Implementing actual image recognition for food items would require integrating with a machine learning model or API, which was not covered in this project.

**Conclusion**
The Food Scanner App is a functional prototype that demonstrates the potential of using modern Android development tools like Jetpack Compose and Navigation Compose to build a user-friendly and visually appealing app. While there are areas for improvement, such as integrating real-time data and image recognition, the app provides a solid foundation for further development.
