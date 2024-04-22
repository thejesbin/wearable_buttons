package com.jesbin.wearable_buttons.wearable_buttons

import android.content.Context
import android.view.KeyEvent
import androidx.annotation.NonNull
import androidx.wear.input.WearableButtons
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

// A Flutter plugin for accessing Wearable Buttons API
class WearableButtonsPlugin : FlutterPlugin, MethodChannel.MethodCallHandler {

    // Channel for communication between Flutter and native code
    private lateinit var channel: MethodChannel

    // Application context for accessing Wearable Buttons API
    private lateinit var context: Context

    // Initialize the plugin and set up the method channel
    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPluginBinding) {
        channel = MethodChannel(flutterPluginBinding.binaryMessenger, "wearable_buttons")
        channel.setMethodCallHandler(this)
        context = flutterPluginBinding.applicationContext
    }

    // Handle method calls from Flutter
    override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: MethodChannel.Result) {
        when (call.method) {
            "getButtonCount" -> {
                val count = getButtonCount()
                result.success(count)
            }
            "getButtonInfo" -> {
                val keycode = call.argument<Int>("keycode")
                if (keycode!= null) {
                    val buttonInfo = getButtonInfo(keycode)
                    result.success(buttonInfo)
                } else {
                    result.error("MISSING_PARAMETER", "Keycode is missing", null)
                }
            }
            else -> result.notImplemented()
        }
    }

    // Clean up the method channel when the plugin is detached
    override fun onDetachedFromEngine(@NonNull binding: FlutterPluginBinding) {
        channel.setMethodCallHandler(null)
    }

    // Get the number of available buttons
    private fun getButtonCount(): Int {
        return WearableButtons.getButtonCount(context)
    }

    // Get information about a specific button
    private fun getButtonInfo(keycode: Int): Any? {
        return WearableButtons.getButtonInfo(context, keycode)
    }
}