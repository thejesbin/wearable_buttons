import 'dart:async';
import 'package:flutter/services.dart';

class WearableButtons {
  // Create a static constant MethodChannel with the channel name 'wearable_buttons'
  static const MethodChannel _channel = MethodChannel('wearable_buttons');

  // Define a static method getButtonCount that returns a Future<int>
  static Future<int> getButtonCount() async {
    // Use the invokeMethod method of the MethodChannel to call the native method 'getButtonCount'
    // and assign the result to the variable buttonCount
    var buttonCount = await _channel.invokeMethod('getButtonCount');

    // Return the buttonCount
    return buttonCount;
  }

  // Define a static method getButtonInfo that takes an int parameter keycode and returns a Future<Object?>
  static Future<Object?> getButtonInfo(int keycode) async {
    // Use a try-catch block to handle any exceptions that might occur during the method invocation
    try {
      // Use the invokeMethod method of the MethodChannel to call the native method 'getButtonInfo'
      // with the keycode parameter and assign the result to the variable buttonInfo
      var buttonInfo =
          await _channel.invokeMethod('getButtonInfo', {"keycode": keycode});

      // Return the buttonInfo
      return buttonInfo;
    } catch (error) {
      // Print the error message if an exception occurs
      print(error);
    }

    // Return null if an exception occurs
    return null;
  }
}
