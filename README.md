# PayrollDemo

An Android application designed to manage employee payrolls, calculate taxes based on specific business rules, and maintain a history of payroll records.

---

## 🚀 How to Run the Project

## 1. Open Project in Android Studio
- Open **Android Studio (Ladybug 2024.2.1 or newer recommended)**
---
## 2. Clone the Repository

- On the welcome screen, click on Clone the Repository
<img width="972" height="313" alt="image" src="https://github.com/user-attachments/assets/792bd2e2-720d-49c7-9ad0-a0ee02253a62" />


<img width="802" height="644" alt="image" src="https://github.com/user-attachments/assets/e5e62ba4-f0b7-44a7-abab-caecc0bc85bf" />

- In the URL box, paste the repository link:
```bash
https://github.com/nagaraj408-test/weSureTest.git

- In the Directory give you path folder where your prject to stotre

3. Sync Gradle
Wait for Gradle sync to complete
Ensure internet connection is active for dependencies download

## Hint : if project fails due to AGP version check your android version and upadte your AGP version accordinly


4. Run the App
Connect Android device or start emulator (API 24+)
Click the ▶ Run button in the toolbar


## 🏗 Architectural Decisions
This project follows a clean layered architecture to improve scalability, maintainability, and testability of the codebase.
---

### Domain Layer (Pure Kotlin)
This is the core layer of the application.
- Contains business models such as `Employee` and `Payroll`
- Contains business logic and use cases (e.g., salary calculation, tax rules)
- Ensures business rules remain stable even if UI or database changes

👉 Why used:
This separation ensures that core business logic is reusable, testable, and not dependent on Android components.
---
##  Data Layer
This layer is responsible for data management.

- Uses Room Database for local storage
- Handles data from local and (if needed) remote sources
- Implements Repository Pattern to abstract data sources
- Provides a clean API to the Domain Layer

👉 Why used:
It isolates data handling logic so changes in database or API do not affect business logic.

---
### Presentation Layer (Jetpack Compose)
This layer handles the UI of the application.

- Built using Jetpack Compose
- Follows MVVM architecture
- ViewModels manage UI state and interact with Domain Layer
- Navigation Compose handles screen flow (List, Create, Detail screens)

👉 Why used:
It keeps UI logic separate from business logic, making the app easier to maintain and scale.
---
### ✅ Overall Benefit of This Architecture
- Better separation of concerns
- Easier testing of business logic
- Scalable and maintainable code structure
- Easy to modify UI or data layer without affecting core logic


✨ Improvements for Future
    Improve UI/UX responsiveness
    Add unit tests
    Improve scalability and maintainability


