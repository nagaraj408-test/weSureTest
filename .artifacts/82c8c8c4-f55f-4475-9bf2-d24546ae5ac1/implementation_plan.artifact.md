# Implementation Plan - UI Enhancements

The goal is to improve the overall UI of the app by adding a consistent `TopAppBar` with titles and back navigation, and generally making the screens more attractive.

## Proposed Changes

### [Component] UI / Screens

#### [MODIFY] [PayrollListScreen.kt](file:///C:/Users/Asus/AndroidStudioProjects/PayrollDemo/app/src/main/java/com/example/payrolldemo/presentaion/screens/PayrollListScreen.kt)
- Add `CenterAlignedTopAppBar` with title "Payroll Records".
- Improve card styling and item layout.

#### [MODIFY] [CreatePayrollScreen.kt](file:///C:/Users/Asus/AndroidStudioProjects/PayrollDemo/app/src/main/java/com/example/payrolldemo/presentaion/screens/CreatePayrollScreen.kt)
- Wrap content in `Scaffold`.
- Add `TopAppBar` with title "New Payroll" and a back button.
- Clean up the "Add Employees" section.

#### [MODIFY] [PayrollDetailScreen.kt](file:///C:/Users/Asus/AndroidStudioProjects/PayrollDemo/app/src/main/java/com/example/payrolldemo/presentaion/screens/PayrollDetailScreen.kt)
- Wrap content in `Scaffold`.
- Add `TopAppBar` with title "Payroll Details" and a back button.
- Add an `onBack` parameter.

#### [MODIFY] [AppNavigation.kt](file:///C:/Users/Asus/AndroidStudioProjects/PayrollDemo/app/src/main/java/com/example/payrolldemo/presentaion/AppNavigation.kt)
- Pass back navigation callbacks to `CreatePayrollScreen` and `PayrollDetailScreen`.

## Verification Plan

### Manual Verification
- Deploy the app.
- Verify `PayrollListScreen` has a title and a floating action button.
- Navigate to `CreatePayrollScreen`, verify the title and the back button (which should pop the backstack).
- Create a payroll, navigate to `PayrollDetailScreen`, verify the title and the back button.
