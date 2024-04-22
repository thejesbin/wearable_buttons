# wearable_buttons

Flutter plugin that can fetch total count of physical buttons and allows access to information about each physical button.

## Setup

### Android

Add the `uses-library` to `AndroidManifest.xml`:

```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android">
    <application
        android:label="wearable_buttons_example"
        android:name="${applicationName}"
        android:icon="@mipmap/ic_launcher">

        <!-- Add below code inside your application tag -->
        <uses-library android:name="com.google.android.wearable" android:required="false" />
           
    </application>
  
</manifest>

```

Update the `minSdkVersion` in `build.gradle`:
```gradle
 
 minSdkVersion 25

```

## Usage

To use this plugin, add `wearable_buttons` as a dependency in your `pubspec.yaml` file.

```yaml
dependencies:
  wearable_buttons: ^0.0.1
```

Then, import `wearable_buttons` in your Dart code.

| Button    | KeyEvent   | 
| --------- | ---------- | 
| Multifunction button 1    | Wearable.buttonOne |
| Multifunction button 2 | Wearable,buttonTwo |
| Multifunction button 3  | Wearable.buttonThree | 

```dart
// Import the package.
import 'package:wearable_buttons/wearable_buttons.dart';

//Method to get button count
@returns int buttonCount

int buttonCount = await WearableButtons.getButtonCount();



//Method to get button info
@param [Wearable] keycode
@returns dynamic buttonInfo

dynamic buttonInfo = await WearableButtons.getButtonInfo(Wearable.buttonOne);
```