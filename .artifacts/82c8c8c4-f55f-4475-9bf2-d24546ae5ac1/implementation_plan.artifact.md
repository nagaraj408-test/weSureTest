# Implementation Plan - Consolidate Dependencies in AppNavigation

The goal is to move the instantiation of the `PayrollRepository` and its dependencies (Database, API) from `MainActivity` into the `AppNavigation` composable. This simplifies `MainActivity` and keeps the dependency graph contained within the navigation layer (acting as a simple composition root).

## Proposed Changes

### [Component] Navigation & Dependency Injection

#### [MODIFY] [MainActivity.kt](file:///C:/Users/Asus/AndroidStudioProjects/PayrollDemo/app/src/main/java/com/example/payrolldemo/MainActivity.kt)
- Remove `AppDatabase` and `PayrollRepository` creation logic.
- Call `AppNavigation()` without arguments.

#### [MODIFY] [AppNavigation.kt](file:///C:/Users/Asus/AndroidStudioProjects/PayrollDemo/app/src/main/java/com/example/payrolldemo/presentaion/AppNavigation.kt)
- Remove the `repository` parameter from the `AppNavigation` function.
- Use `LocalContext.current` to create the `AppDatabase`.
- Use `remember` to instantiate and persist the `PayrollRepository`, `FakePayrollApi`, and all `UseCase`s.

## Verification Plan

### Manual Verification
- Run the app and verify:
    - The app starts normally.
    - Data persists and is retrieved correctly (confirming database/repository are initialized).
    - Navigation between screens works (confirming UseCases are correctly provided to ViewModels).
