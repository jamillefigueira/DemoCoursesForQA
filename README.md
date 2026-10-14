# DemoCoursesForQA 📚

An Android application built with **Kotlin** and **Jetpack Compose** to explore online courses and manage a simple shopping cart.

This project was created as a learning project to practice Android development and Quality Assurance (QA) testing.

## 📱 Features

* **Course Catalog:** Browse available online courses.
* **Course Details:** View course descriptions, categories, prices, and lesson lists.
* **Shopping Cart:** Add courses to the shopping cart.
* **Duplicate Prevention:** Each course can only be added once.
* **Remove Courses:** Remove courses from the shopping cart.
* **Automatic Total:** Calculate the total price of the selected courses.
* **User Feedback:** Display messages when courses are added, removed, or already exist in the cart.

## 🛠️ Technologies

* Kotlin
* Android Studio
* Jetpack Compose
* Material 3
* Coil — image loading
* Git and GitHub

## 🧪 QA Testing Scenarios

The application can be used to practice manual testing, including:

| ID    | Test Scenario                     | Expected Result                                                  |
| ----- | --------------------------------- | ---------------------------------------------------------------- |
| TC-01 | Open the application              | The course catalog is displayed                                  |
| TC-02 | Select a course                   | The course details are displayed correctly                       |
| TC-03 | Add a course to the cart          | The course appears in the cart                                   |
| TC-04 | Add the same course twice         | The course is not duplicated                                     |
| TC-05 | Add two different courses         | Both courses appear in the cart                                  |
| TC-06 | Verify the cart total             | The total matches the sum of the course prices                   |
| TC-07 | Remove a course                   | The course disappears and the total is updated                   |
| TC-08 | Open an empty cart                | An empty-cart message is displayed                               |
| TC-09 | Navigate between catalog and cart | The selected courses remain in the cart while the app is running |

## 🚀 Getting Started

### Prerequisites

* Android Studio
* Android SDK
* An Android emulator or physical Android device
* Internet connection for loading course images

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/YOUR_USERNAME/DemoCoursesForQA.git
   ```

2. Open the project in Android Studio.

3. Allow Gradle to sync.

4. Run the application on an emulator or Android device.

Replace `YOUR_USERNAME` with your GitHub username.

## 📂 Project Structure

```text
DemoCoursesForQA/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/example/democoursesforqa/
│           │   ├── MainActivity.kt
│           │   ├── Course.kt
│           │   ├── CourseScreens.kt
│           │   └── ShoppingCart.kt
│           └── AndroidManifest.xml
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

*Note: The structure above represents the expected organization of the project.*

## ⚠️ Current Limitations

* The shopping cart is stored in memory and is not persisted after the application is closed.
* The application does not process real payments.
* Course images require an internet connection.
* The application is a demonstration project and does not use a backend or database.

## 🎯 Project Goals

* Practice Android application development with Kotlin.
* Understand UI development using Jetpack Compose.
* Explore basic application navigation and state management.
* Identify and document functional test scenarios.
* Build a foundation for future QA automation testing.

## 👩‍💻 Author

**Jamille Figueira**

[GitHub Profile](https://github.com/YOUR_USERNAME)
