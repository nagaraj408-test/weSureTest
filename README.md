# PayrollDemo
An Android application designed to manage employee payrolls, calculate taxes based on specific business rules, and maintain a history of payroll records.

## How to Run the Project

1. **Clone the Repository**:
   ```bash 
   git clone https://github.com/nagaraj408-test/weSureTest.git.

## Note 
   after clone the project you will get some unresolved files so delete thouse then switch to master has the all code 

   
   
 2.Open in Android Studio:
  ◦Open Android Studio (Ladybug 2024.2.1 or newer recommended).
  ◦Select Open and navigate to the PayrollDemo folder.

3.Sync Gradle:
◦Wait for the Gradle sync to complete. Ensure you have an active internet connection to download dependencies.
4.Run the App:
◦Connect an Android device or start an emulator (API 24+).
◦Click the Run button (green play icon) in the toolbar.


## Architectural Decisions
•Domain Layer (Pure Kotlin): This is the core of the app. It contains the business models (Employee, Payroll) and Use Cases. All business rules, such as the 5% tax calculation for non-exempt employees earning over 1,000, are centralized here. This layer has no dependencies on Android frameworks.

•Data Layer: Handles data persistence and retrieval.
◦Room Database: Used for local storage of payrolls and employees.
◦Repository Pattern: Coordinates between the local database and a simulated remote API, providing a clean API for the domain layer.

•Presentation Layer (Jetpack Compose):
◦Material 3: Used for a modern, responsive UI.
◦MVVM Pattern: ViewModels manage the UI state and communicate with the Domain Layer via Use Cases.
◦Navigation Compose: Handles the flow between the List, Create, and Detail screens.

## Anything you would improve or do differently given more time

Yes, if I had more time, I would focus on improving the UI responsiveness and overall user experience. I would also add comprehensive unit tests to increase reliability and maintainability. Additionally, I would integrate Hilt for dependency injection to avoid manually creating objects and to make the architecture more scalable and testable.


