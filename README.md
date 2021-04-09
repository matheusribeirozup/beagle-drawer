# Navigation Drawer + Beagle
This is a sample project that uses [Beagle](https://github.com/ZupIT/beagle) and implements the Navigation Drawer component with support for Toolbar and callback clicks for Activity.

### How to run the project?
First, it is necessary to initialize the `BFF` and for that, just to open the project of the `bff` directory in IntelliJ, for example, and execute the `DrawerApplication`.
That done, just import the project in the `android` directory in Android Studio, for example, and after the project synchronizes, run the app on the emulator, which will already be configured to point to the address `10.0.2.2:8080`.

### What's in the project?
This repository contains two projects, a Backend application (Backend For Frontend) to provide server driven data and an Android application that builds the screens driven by BFF.

 - **android**: includes an activity with the navigation drawer and the content of the destinations server driven.
 - **bff**: simple project that provides an endpoint to obtain a drawer widget and three other endpoints to represent each drawer destination.

### What's the solution?
> The challenge for the solution is on the front, so we will not detail the `BFF`.

With the use of an `Activity` configured with a `DrawerLayout`, the server driven content is displayed both in `NavigationView` to serve as navigation options and in the `FrameLayout` that fills the entire content of the screen.

In order for only part of the screen to be populated with server driven content, Beagle's `loadView` method was used, both in `NavigationView` and `FrameLayout`.

`NavigationView` content is represented by the `DrawerWidget` custom widget and destinations are populated in a `RecyclerView`. Each click on each destination, triggers the `onDestinationClick` method that is treated in `DrawerActivity` to call the `loadView` method again, but to populate the `FrameLayout` with the destination's content.

### Taken decisions
The most commonly applied way to build a drawer with navigation according to the [Android documentation](https://developer.android.com/guide/navigation/navigation-ui), is using `NavigationUI` with navigation graph and menu resources. However, with the use of Beagle to provide server driven views, they are built at runtime, and it is not possible to use features such as navigation graph and menus for `NavigationView`.

Another important detail is that due to the nature of the `DrawerLayout` component with `NavigationView` being strongly linked to an `Activity`, the endpoint `/drawer` that returns only the `DrawerWidget` only makes sense to be called by `DrawerActivity`, which is responsible for doing the routing and negotiations navigation between clicks of destinations.

### Another note
As the implementation is found in a local activity called `DrawerActivity`, for a code hosted on the BFF to navigate to it, it is necessary to trigger a custom action. It is present in this project, but it is not used, with the name of `OpenDrawer`.
