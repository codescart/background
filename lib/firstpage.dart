import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class BackgroundServiceChannel {
  static const MethodChannel _channel =
  MethodChannel('com.example.background_service');

  static Future<void> startBackgroundService() async {
    await _channel.invokeMethod('startBackgroundService');
  }

  static Future<void> stopBackgroundService() async {
    await _channel.invokeMethod('stopBackgroundService');
  }
}

class YourFlutterApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text('Your App')),
        body: Center(
          child: ElevatedButton(
            onPressed: () {
              // Start the background service when the button is pressed
              BackgroundServiceChannel.startBackgroundService();
            },
            child: Text('Start Background Service'),
          ),
        ),
      ),
    );
  }
}
